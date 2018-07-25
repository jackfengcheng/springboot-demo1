package com.xwtech.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Slf4j
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/saveRedis",method =GET, produces = "application/json")
    public String saveRedis(){
        String name = "jack";
        redisTemplate.opsForValue().set("name",name);
        log.info("redis开始缓存了");

        String str  = redisTemplate.opsForValue().get("name");

        if (str != null && str.length() > 0 ){
            log.info("数据库里面去数据成功");
            return str;
        }
        return "缓存成功";
    }
}
