package com.pradipta.batsmanrabbitmqconsumer.rabbitmq;

import com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer.*;
import com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer.implementations.FanoutHandler1;
import com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer.implementations.FanoutHandler2;
import com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer.implementations.FanoutHandler3;
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
    //@Qualifier("TopicListenerContainer")
    SimpleMessageListenerContainer containerTopic(ConnectionFactory connectionFactory, @Qualifier("Normal") MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(TOPIC_QUEUE);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter);
        return simpleMessageListenerContainer;
    }

    @Bean
    //@Qualifier("DirectListenerContainer")
    SimpleMessageListenerContainer containerDirect(ConnectionFactory connectionFactory, @Qualifier("Normal") MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(DIRECT_QUEUE);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter);
        return simpleMessageListenerContainer;
    }

    @Bean
    @Qualifier("ListenerFanout1ListenerContainer")
    SimpleMessageListenerContainer containerFan1(ConnectionFactory connectionFactory, @Qualifier("Fanout1ListenerAdapter") MessageListenerAdapter listenerAdapter1){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(FANOUT_QUEUE_1);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter1);
        return simpleMessageListenerContainer;
    }

    @Bean
    @Qualifier("ListenerFanout2ListenerContainer")
    SimpleMessageListenerContainer containerFan2(ConnectionFactory connectionFactory, @Qualifier("Fanout2ListenerAdapter") MessageListenerAdapter listenerAdapter2){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(FANOUT_QUEUE_2);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter2);
        return simpleMessageListenerContainer;
    }

    @Bean
    @Qualifier("ListenerFanout3ListenerContainer")
    SimpleMessageListenerContainer containerFan3(ConnectionFactory connectionFactory, @Qualifier("Fanout3ListenerAdapter") MessageListenerAdapter listenerAdapter){
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        simpleMessageListenerContainer.setQueueNames(FANOUT_QUEUE_3);
        simpleMessageListenerContainer.setMessageListener(listenerAdapter);
        return simpleMessageListenerContainer;
    }

    @Bean
    @Qualifier("Fanout1ListenerAdapter")
    MessageListenerAdapter listenerAdapterForFanout1(FanoutHandler1 handler){
        return new MessageListenerAdapter(handler, "handle");
    }

    @Bean
    @Qualifier("Fanout2ListenerAdapter")
    MessageListenerAdapter listenerAdapterForFanout2(FanoutHandler2 handler){
        return new MessageListenerAdapter(handler, "handle");
    }

    @Bean
    @Qualifier("Fanout3ListenerAdapter")
    MessageListenerAdapter listenerAdapterForFanout3(FanoutHandler3 handler){
        return new MessageListenerAdapter(handler, "handle");
    }

    @Bean
    @Qualifier("Normal")
    MessageListenerAdapter listenerAdapter(ConsumerHandler handler){
        return new MessageListenerAdapter(handler, "handle");
    }
}