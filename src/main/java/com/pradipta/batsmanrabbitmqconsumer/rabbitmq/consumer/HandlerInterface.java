package com.pradipta.batsmanrabbitmqconsumer.rabbitmq.consumer;

import lombok.Synchronized;

public interface HandlerInterface {
    public void handle(String messageBody);
}
