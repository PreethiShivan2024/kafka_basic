package com.example.springboot_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service//to make this class as a spring bean
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics="${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")//helps us to subscribe the consumer to topics. Topics--> name of topic
    //GroupId specified in application.properties file. Topics will accept only string type its not possible to go with @Value.
    //As when we use @Value we will use that attribute name.
    public void consume(String message) {
        LOGGER.info(String.format("Message Received--->%s ",message));

    }
}
