package com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer;

import com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer.HandlerInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerHandler implements HandlerInterface {
//    @Autowired
//    @Qualifier("TopicListenerContainer")
//    private SimpleMessageListenerContainer simpleMessageListenerContainer;
    @Override
    public void handle(String messageBody){
        log.info("Handling message:");
        log.info(messageBody);
    }
}
