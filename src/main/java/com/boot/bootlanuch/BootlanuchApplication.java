package com.boot.bootlanuch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author admin
 */
@SpringBootApplication
@EnableSwagger2
@ImportResource(locations = "classpath:beans.xml")
@ComponentScan("com.boot.bootlanuch.*")
@MapperScan("com.boot.bootlanuch.dao")
@ServletComponentScan
@EnableAsync
@EnableCaching
public class BootlanuchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootlanuchApplication.class, args);
    }

}
