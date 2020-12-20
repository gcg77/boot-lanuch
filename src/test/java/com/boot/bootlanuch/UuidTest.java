package com.boot.bootlanuch;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.UUID;

@Slf4j
public class UuidTest {
    @Test
    public void uuidTest(){
        log.info(UUID.randomUUID().toString());
    }
}
