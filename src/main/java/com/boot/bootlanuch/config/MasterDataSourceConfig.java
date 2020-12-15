package com.boot.bootlanuch.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.boot.bootlanuch.dao.master",sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class MasterDataSourceConfig {
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "masterdb")
    @Primary
    public DataSource masterDataSource(){
        return new AtomikosDataSourceBean();
    }
    @Bean(name="masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(
            @Qualifier("masterDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/master/*.xml"));
        return bean.getObject();
    }
   /* @Bean(name="masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager(
            @Qualifier("masterDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }*/
    @Bean(name="masterSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate masterSqlSessionTemplate(
            @Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactor) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactor);
    }
}
