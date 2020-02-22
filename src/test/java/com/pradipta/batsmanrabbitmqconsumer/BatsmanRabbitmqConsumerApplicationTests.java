package com.pradipta.batsmanrabbitmqconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.rabbitmq.host=localhost", "spring.data.mongodb.uri=mongodb://localhost:27017/batsman\n"})
class BatsmanRabbitmqConsumerApplicationTests {

	@Test
	void contextLoads() {
	}

}
