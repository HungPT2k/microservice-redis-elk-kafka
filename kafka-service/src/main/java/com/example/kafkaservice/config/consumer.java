package com.example.kafkaservice.config;

import org.springframework.kafka.annotation.KafkaListener;

public class consumer {
    @KafkaListener(topics = "topicName", groupId = "foo")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
