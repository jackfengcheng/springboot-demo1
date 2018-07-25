package com.xwtech.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
@RabbitListener(queues = "fanout.A")
@Slf4j
public class FanoutReceiverA {

    @RabbitHandler
    public void process(String hello, com.rabbitmq.client.Channel channel, Message message) throws IOException {
       log.info("FanoutReceiverA收到  : " + hello +"收到时间"+new Date() + message);

       try {
           channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
           log.info("recevier sucess");
       }catch (IOException e){
           e.printStackTrace();
//           if (message.getMessageProperties().getRedelivered()) {
//               System.out.println("消息已重复处理失败,拒绝再次接收...");
//               channel.basicReject(message.getMessageProperties().getDeliveryTag(), true); // 拒绝消息
//           } else {
               log.info("消息即将再次返回队列处理...");
               channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true); // requeue为是否重新回到队列
//           }

           log.info("recevier false");
       }
    }
}
