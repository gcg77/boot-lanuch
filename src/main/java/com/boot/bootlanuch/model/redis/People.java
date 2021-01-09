package com.boot.bootlanuch.model.redis;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * @author Administrator
 */
@Data
@NoArgsConstructor
@RedisHash("people")
public class People {
    @Id
    private String id;
    private String name;
    private String age;
    public People(String name,String age){
        this.age=age;
        this.name=name;
    }
}
