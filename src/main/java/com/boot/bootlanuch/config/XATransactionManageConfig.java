package com.boot.bootlanuch.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

@Configuration
@EnableTransactionManagement
public class XATransactionManageConfig {
    //user事务
    @Bean(name="userTransaction")
    public UserTransaction userTransaction() throws Exception{
        UserTransactionImp userTransactionImp=new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(10000);
        return userTransactionImp;
    }
    //分布式事务
    @Bean(name="transactionManager")
    public TransactionManager transactionManager() throws Exception{
        UserTransactionManager userTransactionManager=new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        return userTransactionManager;
    }
    //事务管理器
    @Bean(name="platformTransactionManager")
    @DependsOn({"userTransaction","transactionManager"})
    public PlatformTransactionManager platformTransactionManager() throws Exception{
        return new JtaTransactionManager(userTransaction(),transactionManager());
    }
}
