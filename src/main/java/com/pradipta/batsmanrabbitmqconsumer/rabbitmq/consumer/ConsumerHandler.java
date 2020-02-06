package com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
@Slf4j
public class ConsumerHandler {
    public void handleMessage(String messageBody){
        log.info("Handling message:");
        log.info(messageBody);
    }

    public void handleMessageForFanout1(String messageBody){
        System.out.println("This is working");
        log.info("Fanout 1");
        log.info("Handling message:");
        log.info(messageBody);
    }

    public void handleMessageForFanout2(String messageBody){
        System.out.println("This is working");
        log.info("Fanout 2");
        log.info("Handling message:");
        log.info(messageBody);
    }

    public void handleMessageForFanout3(String messageBody){
        System.out.println("This is working");
        log.info("Fanout 3");
        log.info("Handling message:");
        log.info(messageBody);
    }
}
