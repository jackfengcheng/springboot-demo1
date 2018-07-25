package com.xwtech.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SimpleSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public  void SimpleSender() {
        String AMQP ="这个是rabbitmq测试数据";
         amqpTemplate.convertAndSend("queue",AMQP);
         log.info("2--------------Sender" +AMQP );
    }
}
