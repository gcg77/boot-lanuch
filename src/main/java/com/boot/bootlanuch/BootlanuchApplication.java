package com.boot.bootlanuch;

import com.sun.org.apache.bcel.internal.classfile.ConstantValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ImportResource(locations="classpath:beans.xml")
public class BootlanuchApplication {
    public static void main(String[] args) {
        System.setProperty("jasypt.encryptor.password","password");
        SpringApplication.run(BootlanuchApplication.class, args);
    }

}
