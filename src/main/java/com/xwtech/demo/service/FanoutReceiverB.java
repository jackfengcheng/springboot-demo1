package com.xwtech.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
@Slf4j
public class FanoutReceiverB {

    @RabbitHandler
    public void process(String message) {
        log.info("B--------------fanout Receiver B  : " + message
        );
    }
}
