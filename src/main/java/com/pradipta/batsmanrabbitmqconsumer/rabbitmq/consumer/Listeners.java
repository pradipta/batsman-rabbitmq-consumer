package com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer;

import com.pradipta.batsmanrabbitmqconsumer.constants.Constants;
import com.pradipta.batsmanrabbitmqconsumer.dto.OrderRequest;
import com.pradipta.batsmanrabbitmqconsumer.persistance.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listeners {
    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = Constants.TOPIC_QUEUE)
    public void listenTopicQueue(OrderRequest orderRequest) {
        if(!orderService.documentExists(orderRequest.getOrderId())){
            System.out.println("Creating doc in topic");
            orderService.createDocument(orderRequest);
        }
        log.info("Message at Queue {} : {}", Constants.TOPIC_QUEUE, orderRequest);
    }

    @RabbitListener(queues = Constants.DIRECT_QUEUE)
    public void listenDirectQueue(OrderRequest orderRequest) {
        if(!orderService.documentExists(orderRequest.getOrderId())){
            System.out.println("Creating doc in direct");
            orderService.createDocument(orderRequest);
        }
        log.info("Message at Queue {} : {}", Constants.DIRECT_QUEUE, orderRequest);
    }

    @RabbitListener(queues = Constants.FANOUT_QUEUE_1)
    public void listenFanoutQueue1(OrderRequest orderRequest) {
        if(!orderService.documentExists(orderRequest.getOrderId())){
            System.out.println("Creating doc in fanout1");
            orderService.createDocument(orderRequest);
        }
        log.info("Message at Queue {} : {}", Constants.FANOUT_QUEUE_1, orderRequest);
    }

    @RabbitListener(queues = Constants.FANOUT_QUEUE_2)
    public void listenFanoutQueue2(OrderRequest orderRequest) {
        if(!orderService.documentExists(orderRequest.getOrderId())){
            System.out.println("Creating doc in fanout2");
            orderService.createDocument(orderRequest);
        }
        log.info("Message at Queue {} : {}", Constants.FANOUT_QUEUE_2, orderRequest);
    }

    @RabbitListener(queues = Constants.FANOUT_QUEUE_3)
    public void listenFanoutQueue3(OrderRequest orderRequest) {
        if(!orderService.documentExists(orderRequest.getOrderId())){
            System.out.println("Creating doc in fanout3");
            orderService.createDocument(orderRequest);
            System.out.println("Ordee printing: "+orderService.findOrder(orderRequest.getOrderId()));
        }
        log.info("Message at Queue {} : {}", Constants.FANOUT_QUEUE_3, orderRequest);
    }
}
