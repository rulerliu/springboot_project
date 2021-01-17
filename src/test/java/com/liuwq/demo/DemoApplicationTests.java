package com.liuwq.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void contextLoads() {
        // 存
        redisTemplate.opsForValue().set("myKey", "sfsdfsdfsfs");

        // 取
        String myKey = redisTemplate.opsForValue().get("myKey");
        System.out.println("---------------------------------" + myKey);

        // 删
        redisTemplate.delete("name");
    }

}
