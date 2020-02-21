package com.pradipta.batsmanrabbitmqconsumer.persistance;

import com.pradipta.batsmanrabbitmqconsumer.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    //create Document
    public OrderRequest createDocument(OrderRequest orderRequest){
        return orderRepository.save(orderRequest);
    }

    public Boolean documentExists(String id){
        return orderRepository.findById(id).isPresent();
    }

    public Optional<OrderRequest> findOrder(String id){
        return orderRepository.findById(id);
    }
}
