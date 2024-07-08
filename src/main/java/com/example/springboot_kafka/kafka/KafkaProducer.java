package com.example.springboot_kafka.kafka;

import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service//to make this class as a spring bean
public class KafkaProducer {
    @Value("${spring.kafka.topic.name}")
    private String topicName;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate; //this template is provided by spring boot framework we can utilize it.
    //topicname-->key, message-->value

    //NOTE: IF WE ARE NOT USING SPRING BOOT WE NEED TO WRITE CODE FOR KAFKA TEMPLATE.
    //THAT BURDEN SPRING BOOT REDUCED
    ///No need to use @Autowired as spring will do automatic autowire for single constructor
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send(topicName,message);//sends the message to kafka topic
    }
}
