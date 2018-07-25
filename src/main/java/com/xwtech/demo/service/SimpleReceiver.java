package com.xwtech.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue")
@Slf4j
public class SimpleReceiver {

    @RabbitHandler
    public  void SimpleReceiver(String queue){
            log.info("3--------------Receiver  : " + queue);
    }
}
