package com.xwtech.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@Slf4j
public class CookieController {

    @RequestMapping(value = "/getCookie", method =GET, produces = "application/json")
    public  String getCookie(@CookieValue("SESSION") String cookie){
        String Str  = cookie;
        log.info(Str);
        return Str;
    }


    @RequestMapping(value = "/getHerder", method =GET, produces = "application/json")
    public Map<String,Object> getHerder(@RequestHeader("Accept") String Accept, @RequestHeader("User-Agent") String Agent){
        Map<String,Object> map = new HashMap<>();
        map.put("Accept",Accept);
        map.put("Request url",Agent);
        log.info("map =================="+map);
        return map;
    }
}
