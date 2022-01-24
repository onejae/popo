package com.rightime.popo.broker;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumer {
    @KafkaListener(topics="${kafka.topics.trigger.name}", id="${kafka.topics.trigger.group.id")
    public void consume(String message) {
        System.out.println("Message received : " + message);
    }
}

