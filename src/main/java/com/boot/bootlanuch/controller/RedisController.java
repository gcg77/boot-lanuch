package com.boot.bootlanuch.controller;

import com.boot.bootlanuch.model.redis.People;
import com.boot.bootlanuch.model.redis.PersonRepository;
import com.boot.bootlanuch.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Resource
    private PersonRepository repository;
    @GetMapping("/set")
    public RestResponse setRedis(){
        redisTemplate.opsForValue().set("myKey","myValue");
        log.info("redis-key"+redisTemplate.opsForValue().get("myKey"));
        return RestResponse.success().put("data",redisTemplate.opsForValue().get("myKey"));
    }
    @GetMapping("/repository")
    public RestResponse repository(){
        People rand=new People("get","123");
        repository.save(rand);
        Optional<People> op=repository.findById(rand.getId());
        People end=op.get();
        return RestResponse.success().put("data",end);
    }
}
