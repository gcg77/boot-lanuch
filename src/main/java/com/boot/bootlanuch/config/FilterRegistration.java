package com.boot.bootlanuch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gcg
 */
@Slf4j
@Configuration
public class FilterRegistration {
    @Bean
    public FilterRegistrationBean filter() {
        FilterRegistrationBean register = new FilterRegistrationBean();
        register.setFilter(new CustomFilter());
        register.setName("customFilter");
        register.addUrlPatterns("/**");
        register.setOrder(1);
        return register;
    }

}
