package com.liuwq.demo.rabbitmq.consumer.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "lwqDirectQueue")//监听的队列名称 lwqDirectQueue
public class DirectReceiver2 {
 
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver 2  0118消费者收到消息  : " + testMessage.toString());
    }
 
}