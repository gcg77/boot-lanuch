package com.boot.bootlanuch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
@SpringBootTest
@Slf4j
public class RestTemplateTest {
    @Resource
    private RestTemplate restTemplate;
    @Test
    public void testTemplate(){

    }
}
