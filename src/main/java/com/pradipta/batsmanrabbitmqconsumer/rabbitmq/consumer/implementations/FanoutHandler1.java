package com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer.implementations;

import com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer.HandlerInterface;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FanoutHandler1 implements HandlerInterface {
    @Autowired
    @Qualifier("ListenerFanout1ListenerContainer")
    private SimpleMessageListenerContainer simpleMessageListenerContainer;
    @Override
    public void handle(String messageBody) {
        log.info("Queue name: "+simpleMessageListenerContainer.getQueueNames()[0]+"\n"+
                "Handling message:"+
                messageBody);
    }
}
