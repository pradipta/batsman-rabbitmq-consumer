package com.pradipta.batsmanrabbitmqconsumer.persistance;

import com.pradipta.batsmanrabbitmqconsumer.dto.OrderRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderRequest, String> {
}
