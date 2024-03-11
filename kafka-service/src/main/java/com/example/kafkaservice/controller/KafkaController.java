package com.example.kafkaservice.controller;

import com.example.kafkaservice.Object.product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka-queue")
public class KafkaController {
    @PostMapping("/publisher")
    public String publisher(@RequestBody product p){
        return null;
    }

}
