package com.pradipta.batsmanrabbitmqconsumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pradipta.batsmanrabbitmqconsumer.dto.OrderRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class DTOTest {
    @Autowired
    private TestConfiguration testConfiguration;
    @Test
    public void checkDto() throws JsonProcessingException {
        OrderRequest orderRequest = testConfiguration.getOrderRequest();
        assertThat(orderRequest.getOrderId().equals("asdaasdg"));
    }
}
