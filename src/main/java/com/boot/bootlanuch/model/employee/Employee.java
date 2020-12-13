package com.boot.bootlanuch.model.employee;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@PropertySource(value = "classpath:employee.properties",encoding = "utf-8")
public class Employee {
    @Value("#{'${employee.names}'.split('\\|')}")
    private List<String> employeeNames;
    @Value("#{'${employee.names}'.split('\\|')[0]}")
    private String employeeNameOne;
    @Value("#{${employee.age}}")
    private Map<String,Integer> employeeAge;
    //@Value("#{${employee.age}.two}")
    @Value("#{${employee.age}['two']}")
    private String employeeAgeTwo;
    @Value("#{${employee.age}['five'] ?:11}")
    private String employeeAgeDefault;
    @Value("#{systemProperties['java.home']}")
    private String javaHome;
    @Value("#{systemProperties['user.dir']}")
    private String userDir;
}
