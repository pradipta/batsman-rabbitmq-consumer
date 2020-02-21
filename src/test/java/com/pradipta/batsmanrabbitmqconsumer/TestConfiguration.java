package com.pradipta.batsmanrabbitmqconsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pradipta.batsmanrabbitmqconsumer.dto.OrderRequest;
import lombok.SneakyThrows;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
    @SneakyThrows
    public static OrderRequest getOrderRequest(){
        String jsonOrderRequest = "{\"orderId\":\"asdaasdg\",\"products\":[{\"name\":\"abc\",\"price\":1010},{\"name\":\"abc1\",\"price\":10101}],\"receipient\":{\"basicProfile\":{\"name\":\"\",\"phoneNumber\":\"\",\"email\":\"\"},\"addresses\":[{\"addressType\":\"billing\",\"line1\":\"\",\"line2\":\"\",\"city\":\"\",\"state\":\"\",\"country\":\"\"},{\"addressType\":\"delivery\",\"line1\":\"\",\"line2\":\"\",\"city\":\"\",\"state\":\"\",\"country\":\"\"}]}}";

        ObjectMapper objectMapper = new ObjectMapper();
        OrderRequest orderRequest = objectMapper.readValue(jsonOrderRequest, OrderRequest.class);
        System.out.println(orderRequest);
        return orderRequest;
    }
}
