package com.boot.bootlanuch.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author admin
 */
@Configuration
@MapperScan(basePackages = "com.boot.bootlanuch.dao.core",sqlSessionTemplateRef = "coreSqlSessionTemplate")
public class CoreDataSourceConfig {
    @Bean(name = "coreDataSource")
    @ConfigurationProperties(prefix = "coredb")
    /**
     * 创建DataSource
     */
    public DataSource masterDataSource(){
        return new AtomikosDataSourceBean();
    }

    /**
     * coreSqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name="coreSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(
            @Qualifier("coreDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/core/*.xml"));
        return bean.getObject();
    }

    /**
     * coreSqlSessionTemplate
     * @param sqlSessionFactor
     * @return
     * @throws Exception
     */
    @Bean(name="coreSqlSessionTemplate")
    public SqlSessionTemplate masterSqlSessionTemplate(
            @Qualifier("coreSqlSessionFactory") SqlSessionFactory sqlSessionFactor) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactor);
    }
}
