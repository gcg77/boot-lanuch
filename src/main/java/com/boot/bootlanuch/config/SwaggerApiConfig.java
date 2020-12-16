package com.boot.bootlanuch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gcg
 */
@Configuration
@EnableSwagger2
public class SwaggerApiConfig {
@Bean
public Docket createDocketApi(){
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .paths(PathSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.boot.bootlanuch"))
            .build();

}
public ApiInfo apiInfo(){
    Contact contact=new Contact("郭晨刚", "","" );
    return new ApiInfoBuilder()
            .title("boot lanuch 使用swagger创建API文档")
            .version("1.0.0")
            .contact(contact)
            .build();
}
}
