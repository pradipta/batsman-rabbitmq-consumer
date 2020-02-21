package com.pradipta.batsmanrabbitmqconsumer.dynamo;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
        (basePackages = "com.pradipta.batsmanrabbitmqconsumer")
public class DynamoDBConfig {
}
