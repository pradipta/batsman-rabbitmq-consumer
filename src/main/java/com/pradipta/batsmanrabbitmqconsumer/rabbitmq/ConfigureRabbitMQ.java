package com.pradipta.batsmanrabbitmqconsumer.rabbitmq;

import com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer.ConsumerHandler;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureRabbitMQ {
    public static final String TOPIC_QUEUE = "pradipta.bowlertopicqueue";
    public static final String TOPIC_EXCHANGE = "pradipta.bowlertopicexchange";
    public static final String TOPIC_ROUTING_KEY = "pradipta.bowlertopickey";

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(TOPIC_QUEUE);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter);
        return simpleMessageListenerContainer;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(ConsumerHandler handler){
        return new MessageListenerAdapter(handler, "handleMessage");
    }
}
