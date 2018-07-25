package com.xwtech.demo.controller;

import com.xwtech.demo.service.FanoutSender;
import com.xwtech.demo.service.SimpleSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Slf4j
public class RabbitMqController {

    @Autowired
    private SimpleSender simpleSender;
    @Autowired
    private FanoutSender fanoutSender;

    @RequestMapping("/rabbitMq")
    public  String rabbitMq() {
        simpleSender.SimpleSender();
        log.info("1------------rabbitMqSender发送消息成功");
        return "sucess";
    }
    @RequestMapping(value = "/fanout",method =GET, produces = "application/json")
    public  String fanout() {
        fanoutSender.send();
        log.info("1------------fanoutSender");
        return "sucess";
    }

}
