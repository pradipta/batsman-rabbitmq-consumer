package com.pradipta.batsmanrabbitmqconsumer.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class OrderRequest implements Serializable {
    private static final long serialVersionUID = 123123123123L;
    private String orderId;
    private List<Product> products;
    private Receipient receipient;
}
