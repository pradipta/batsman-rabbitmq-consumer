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
    public static final String DIRECT_QUEUE = "pradipta.bowlerdirectqueue";
    public static final String FANOUT_QUEUE_1 = "pradipta.bowlerfanoutqueue1";
    public static final String FANOUT_QUEUE_2 = "pradipta.bowlerfanoutqueue2";
    public static final String FANOUT_QUEUE_3 = "pradipta.bowlerfanoutqueue3";

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(TOPIC_QUEUE, DIRECT_QUEUE, FANOUT_QUEUE_1, FANOUT_QUEUE_2, FANOUT_QUEUE_3);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter);
        return simpleMessageListenerContainer;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(ConsumerHandler handler){
        return new MessageListenerAdapter(handler, "handleMessage");
    }
}
