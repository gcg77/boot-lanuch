package com.boot.bootlanuch;

import com.boot.bootlanuch.model.family.Family;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyBeanYmlTest {
    @Resource
    private  Family  family;

    @Test
    public void ymlTest() throws Exception {
        log.info("familyName:"+family);
    }
}
