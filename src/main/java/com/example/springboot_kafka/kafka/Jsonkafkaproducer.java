package com.example.springboot_kafka.kafka;

import com.example.springboot_kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service //to make this class as spring bean
public class Jsonkafkaproducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Jsonkafkaproducer.class);
    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;
    private KafkaTemplate<String, User> kafkaTemplate;//string--> topic name, User--> value
 ///No need to use @Autowired as spring will do automatic autowire for single constructor
    public Jsonkafkaproducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data) {
        LOGGER.info("Msg sent.."+data);
        Message<User> message = MessageBuilder.withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();
        kafkaTemplate.send(message);
    }
}
