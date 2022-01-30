package com.rightime.popo.controllers;

import com.rightime.popo.broker.EventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EventTrigger {
    @Autowired
    private EventProducer eventProducer;

    @Scheduled(cron = "*/5 * * * * *")
    public void tick() throws Exception {
        eventProducer.sendMessage("WORK");
    }
}