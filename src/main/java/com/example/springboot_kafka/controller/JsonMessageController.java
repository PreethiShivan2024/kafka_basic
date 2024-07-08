package com.example.springboot_kafka.controller;

import com.example.springboot_kafka.kafka.Jsonkafkaproducer;
import com.example.springboot_kafka.payload.User;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    private Jsonkafkaproducer jsonkafkaproducer;

    public JsonMessageController(Jsonkafkaproducer jsonkafkaproducer) {
        this.jsonkafkaproducer = jsonkafkaproducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody  User user){
        jsonkafkaproducer.sendMessage(user);
        return ResponseEntity.ok("JSON Message sent to kafka topic");

    }
}
