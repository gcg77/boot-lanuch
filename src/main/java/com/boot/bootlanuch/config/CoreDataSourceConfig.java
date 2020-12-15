package com.boot.bootlanuch.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.boot.bootlanuch.dao.core",sqlSessionTemplateRef = "coreSqlSessionTemplate")
public class CoreDataSourceConfig {
    @Bean(name = "coreDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.core")
    public DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name="coreSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(
            @Qualifier("coreDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/core/*.xml"));
        return bean.getObject();
    }
    @Bean(name="coreTransactionManager")
    public DataSourceTransactionManager masterTransactionManager(
            @Qualifier("coreDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name="coreSqlSessionTemplate")
    public SqlSessionTemplate masterSqlSessionTemplate(
            @Qualifier("coreSqlSessionFactory") SqlSessionFactory sqlSessionFactor) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactor);
    }
}
