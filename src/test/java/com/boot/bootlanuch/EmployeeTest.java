package com.boot.bootlanuch;

import com.boot.bootlanuch.model.employee.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTest {
    @Resource
    private Employee employee;

    @Test
    public void ymlTest() throws Exception {
        log.info("employeeNames:"+employee.toString());
    }
}
