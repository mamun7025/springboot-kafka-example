package com.mamun25dev.springkafkabasic.controller;

import com.google.gson.Gson;
import com.mamun25dev.springkafkabasic.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private Gson gson;

    @PostMapping("/produce")
    public ResponseEntity<String> postModelToKafka(@RequestBody Employee emp) throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("topic_demo", gson.toJson(emp));
        return new ResponseEntity<>(result.get().getProducerRecord().value(), HttpStatus.OK);
    }

    @GetMapping("/produce2")
    public ResponseEntity<String> postModelToKafka2(@RequestParam(name = "pMsg") String pMsg) throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("topic11demo", pMsg);
        return new ResponseEntity<>(result.get().getProducerRecord().value(), HttpStatus.OK);
    }

}
