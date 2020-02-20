package com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer;

import com.pradipta.batsmanrabbitmqconsumer.constants.Constants;
import com.pradipta.batsmanrabbitmqconsumer.dto.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listeners {
    @RabbitListener(queues = Constants.TOPIC_QUEUE)
    public void listenTopicQueue(OrderRequest orderRequest) {
        log.info("Message at Queue {} : {}", Constants.TOPIC_QUEUE, orderRequest);
    }

    @RabbitListener(queues = Constants.DIRECT_QUEUE)
    public void listenDirectQueue(OrderRequest orderRequest) {
        log.info("Message at Queue {} : {}", Constants.DIRECT_QUEUE, orderRequest);
    }

    @RabbitListener(queues = Constants.FANOUT_QUEUE_1)
    public void listenFanoutQueue1(OrderRequest orderRequest) {
        log.info("Message at Queue {} : {}", Constants.FANOUT_QUEUE_1, orderRequest);
    }

    @RabbitListener(queues = Constants.FANOUT_QUEUE_2)
    public void listenFanoutQueue2(OrderRequest orderRequest) {
        log.info("Message at Queue {} : {}", Constants.FANOUT_QUEUE_2, orderRequest);
    }

    @RabbitListener(queues = Constants.FANOUT_QUEUE_3)
    public void listenFanoutQueue3(OrderRequest orderRequest) {
        log.info("Message at Queue {} : {}", Constants.FANOUT_QUEUE_3, orderRequest);
    }
}
