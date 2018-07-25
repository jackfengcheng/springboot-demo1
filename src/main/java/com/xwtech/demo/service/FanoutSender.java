package com.xwtech.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class FanoutSender implements  RabbitTemplate.ReturnCallback {

//    @Autowired
//    private AmqpTemplate rabbitTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public  void send () {
        String context = "hi, fanout msg ";
        log.info("Sender 发送的内容是: " + context);
//        rabbitTemplate.convertAndSend("fanoutExchange","", context);
        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback((correlationData, ack, cause) ->{
            if (!ack) {
                System.out.println("send消息发送失败" + cause + correlationData.toString());
            } else {
                System.out.println("send 消息发送成功 ");
            }
        });
//        Message message = MessageBuilder.withBody(context.getBytes())
//                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
//                .setContentEncoding("utf-8")
//                .setMessageId(UUID.randomUUID()+"")
//                .build();
//        log.info("message" + message);
        this.rabbitTemplate.convertAndSend("fanoutExchange","",context);
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("sender return success" + message.toString()+"==="+i+"==="+s1+"==="+s2);
    }
}
