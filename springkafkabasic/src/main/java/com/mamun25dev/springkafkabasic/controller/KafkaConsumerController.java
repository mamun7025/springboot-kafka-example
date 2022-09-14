package com.mamun25dev.springkafkabasic.controller;

import com.google.gson.Gson;
import com.mamun25dev.springkafkabasic.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaConsumerController {

    @Autowired
    private Gson gson;

    @KafkaListener(topics = { "topic_demo" })
    public void getTopics(@RequestBody String emp) {
        System.out.println("Kafka event consumed is: " + emp);
        Employee model = gson.fromJson(emp, Employee.class);
        System.out.println("Model converted value: " + model.toString());
    }

}
