package com.boot.bootlanuch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ImportResource(locations="classpath:beans.xml")
@MapperScan("com.boot.bootlanuch.dao")
public class BootlanuchApplication {
    public static void main(String[] args) {
        System.setProperty("jasypt.encryptor.password","password");
        SpringApplication.run(BootlanuchApplication.class, args);
    }

}
