package com.pradipta.batsmanrabbitmqconsumer.rabbitmq;

import com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer.ConsumerHandler;
import com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer.FanoutHandler;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
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
    SimpleMessageListenerContainer containerTopic(ConnectionFactory connectionFactory, @Qualifier("Normal") MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(TOPIC_QUEUE);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter);
        return simpleMessageListenerContainer;
    }

    @Bean
    SimpleMessageListenerContainer containerDirect(ConnectionFactory connectionFactory, @Qualifier("Normal") MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(DIRECT_QUEUE);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter);
        return simpleMessageListenerContainer;
    }

    @Bean
    SimpleMessageListenerContainer containerFan1(ConnectionFactory connectionFactory, @Qualifier("Fanout1") MessageListenerAdapter listenerAdapter1){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(FANOUT_QUEUE_1);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter1);
        return simpleMessageListenerContainer;
    }

    @Bean
    SimpleMessageListenerContainer containerFan2(ConnectionFactory connectionFactory, @Qualifier("Fanout2") MessageListenerAdapter listenerAdapter2){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(FANOUT_QUEUE_2);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter2);
        return simpleMessageListenerContainer;
    }

    @Bean
    SimpleMessageListenerContainer containerFan3(ConnectionFactory connectionFactory, @Qualifier("Fanout3") MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(FANOUT_QUEUE_3);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter);
        return simpleMessageListenerContainer;
    }

    @Bean
    @Qualifier("Fanout1")
    MessageListenerAdapter listenerAdapterForFanout1(FanoutHandler handler){
        return new MessageListenerAdapter(handler, "handleMessageForFanout1");
    }

    @Bean
    @Qualifier("Fanout2")
    MessageListenerAdapter listenerAdapterForFanout2(FanoutHandler handler){
        return new MessageListenerAdapter(handler, "handleMessageForFanout2");
    }

    @Bean
    @Qualifier("Fanout3")
    MessageListenerAdapter listenerAdapterForFanout3(FanoutHandler handler){
        return new MessageListenerAdapter(handler, "handleMessageForFanout3");
    }

    @Bean
    @Qualifier("Normal")
    MessageListenerAdapter listenerAdapter(ConsumerHandler handler){
        return new MessageListenerAdapter(handler, "handleMessage");
    }
}