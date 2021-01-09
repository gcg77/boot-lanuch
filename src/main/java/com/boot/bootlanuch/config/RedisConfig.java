package com.boot.bootlanuch.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Configuration
@EnableAutoConfiguration
@Data
@ConfigurationProperties(prefix = "caching")
@Slf4j
public class RedisConfig {

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate redisTemplate=new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //设置完这个可以直接将对象以json格式存入redis中，但是取出来的时候要用JSON.parseArray(Json.toJsonString(object),Object.class)解析一下
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        //调用后完成设置
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    /**
     *     让redis缓存的序列化方式使用redisTemplate.getValueSerializer()
     *     不再使用默认的jdk的序列化方式
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate){
        RedisCacheWriter redisCacheWriter=
                RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
        RedisCacheConfiguration redisCacheConfiguration=this.redisCacheConfiguration(redisTemplate,
                RedisCacheConfiguration.defaultCacheConfig().getTtl().getSeconds());
        return new RedisCacheManager(redisCacheWriter,redisCacheConfiguration,this.initialCacheConfigurations(redisTemplate));

    }
    private Map<String,Long> ttlmap;

    /**
     * 自定义initialCacheConfigurations
     * @param redisTemplate
     * @return
     */
    private Map<String, RedisCacheConfiguration> initialCacheConfigurations(RedisTemplate redisTemplate){
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap=new HashMap<>();
        for(Map.Entry<String,Long> entry:ttlmap.entrySet()){
            String cacheName=entry.getKey();
            log.info("cacheName:"+cacheName);
            Long ttl=entry.getValue();
            redisCacheConfigurationMap.put(cacheName,this.redisCacheConfiguration(redisTemplate,ttl)
            );
        }
        return redisCacheConfigurationMap;
    }
    /**
     * 根据传参构建缓存配置
     * @param redisTemplate
     * @param ttl
     * @return
     */
    private RedisCacheConfiguration redisCacheConfiguration(RedisTemplate redisTemplate,Long ttl){
        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(
                        redisTemplate.getValueSerializer()))
                .entryTtl(Duration.ofSeconds(ttl));
    }
}