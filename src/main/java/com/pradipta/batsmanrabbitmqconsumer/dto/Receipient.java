package com.pradipta.batsmanrabbitmqconsumer.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class Receipient implements Serializable {
    private Profile basicProfile;
    private List<Address> addresses;
}
