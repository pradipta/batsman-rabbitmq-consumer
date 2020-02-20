package com.pradipta.batsmanrabbitmqconsumer.rabbitmq;

import com.pradipta.batsmanrabbitmqconsumer.constants.Constants;
import org.springframework.amqp.core.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ConfigureRabbitMQ {

    @Bean
    public Declarables topicExchangeBindings() {
        TopicExchange topicExchange = new TopicExchange(Constants.TOPIC_EXCHANGE);
        Queue topicQueue = new Queue(Constants.TOPIC_QUEUE, false);
        return new Declarables(topicQueue, topicExchange, BindingBuilder
                .bind(topicQueue)
                .to(topicExchange)
                .with(Constants.TOPIC_ROUTING_KEY)
        );
    }


    @Bean
    public Declarables directExchangeBindings() {
        DirectExchange directExchange = new DirectExchange(Constants.DIRECT_EXCHANGE);
        Queue directQueue = new Queue(Constants.DIRECT_QUEUE, false);
        return new Declarables(directQueue, directExchange, BindingBuilder
                .bind(directQueue)
                .to(directExchange)
                .with("")
        );
    }

    @Bean
    public Declarables fanoutExchangeBindings() {
        FanoutExchange fanoutExchange = new FanoutExchange(Constants.FANOUT_EXCHANGE);
        Queue fanoutQueue1 = new Queue(Constants.FANOUT_QUEUE_1, false);
        Queue fanoutQueue2 = new Queue(Constants.FANOUT_QUEUE_2, false);
        Queue fanoutQueue3 = new Queue(Constants.FANOUT_QUEUE_3, false);
        return new Declarables(fanoutQueue1, fanoutQueue2, fanoutQueue3, fanoutExchange,
                BindingBuilder.bind(fanoutQueue1).to(fanoutExchange),
                BindingBuilder.bind(fanoutQueue2).to(fanoutExchange),
                BindingBuilder.bind(fanoutQueue3).to(fanoutExchange)
        );
    }

}