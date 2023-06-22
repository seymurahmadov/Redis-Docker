package com.example.redisdocker.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Component
public class RedisService {

    private final RedisTemplate<String,Object> redisTemplate;

    public RedisService(RedisTemplate<String,Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void redisStorage(String id, String name){
        redisTemplate.opsForValue().set(id,name,1,TimeUnit.MINUTES);
    }

    public void deleteKey(String id){
        redisTemplate.delete(id);
    }
}
