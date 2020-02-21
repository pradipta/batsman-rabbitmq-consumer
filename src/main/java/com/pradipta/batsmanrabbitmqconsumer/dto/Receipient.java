package com.pradipta.batsmanrabbitmqconsumer.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Document
public class Receipient implements Serializable {
    private Profile basicProfile;
    private List<Address> addresses;
}
