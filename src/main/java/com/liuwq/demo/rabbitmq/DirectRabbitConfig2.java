package com.liuwq.demo.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : JCccc
 * @CreateTime : 2019/9/3
 * @Description :
 **/
@Configuration
public class DirectRabbitConfig2 {

    public static final String LWQ_DIRECT_QUEUE = "lwqDirectQueue";
    public static final String LWQ_DIRECT_EXCHANGE = "lwqDirectExchange";
    public static final String LWQ_DIRECT_ROUTING_KEY = "lwqDirectRouting";
    /**
     * 创建一个队列 名字为lwq....
     * @return
     */
    @Bean
    public Queue lwqDirectQueue() {
        return new Queue(LWQ_DIRECT_QUEUE,true);
    }

    /**
     * 创建一个交换机 名字为lwq..change   (名字跟队列 有联系)
     * @return
     */
    @Bean
    DirectExchange lwqDirectExchange() {
        return new DirectExchange(LWQ_DIRECT_EXCHANGE,true,false);
    }

    /**
     * 绑定队列跟交换机 并设置路油建；
     * @return
     */
    @Bean
    Binding lwqBindingDirect() {
        Queue lwqDirectQueue = lwqDirectQueue();
        DirectExchange lwqDirectExchange = lwqDirectExchange();
        return BindingBuilder.bind(lwqDirectQueue).to(lwqDirectExchange).with(LWQ_DIRECT_ROUTING_KEY);
    }

}