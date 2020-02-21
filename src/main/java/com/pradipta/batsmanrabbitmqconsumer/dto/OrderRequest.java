package com.pradipta.batsmanrabbitmqconsumer.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Document(collection = "batsman")
@Component
public class OrderRequest implements Serializable {
    @Id
    private String orderId;
    private List<Product> products;
    private Receipient receipient;
}
