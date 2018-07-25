package com.xwtech.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Slf4j
public class SpringSessionController {
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/putSession",method =GET, produces = "application/json")
    public  String putSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info(port + session.getId());
        String name = "jack";
        session.setAttribute("user",name);
        return "name";
    }
}
