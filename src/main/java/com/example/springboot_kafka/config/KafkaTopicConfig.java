package com.example.springboot_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;
    @Bean//we want to consider NewTopic as bean... That's why @Bean
    public NewTopic javaguidesTopic() {//make sure to import NewTopic from org.apache.kafka.clients.admin.NewTopic this package
        return TopicBuilder.name(topicName).build();//if we want partition in a topic we can TopicBuilder.name("javGuides").partitions(10).build(); 10 Indicates no of partitions.
        //if we are not providing partitions then default partition of kafka will be considered.
    }

    @Bean
    public NewTopic javaguidesJsonTopic() {
        return TopicBuilder.name(topicJsonName).build();
    }
}
