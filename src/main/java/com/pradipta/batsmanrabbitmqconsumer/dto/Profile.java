package com.pradipta.batsmanrabbitmqconsumer.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@ToString
@Document
public class Profile implements Serializable {
    private String name;
    private String phoneNumber;
    private String email;
}
