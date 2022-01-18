package com.rightime.popo.controllers;

import org.springframework.scheduling.annotation.Scheduled;

public class EventTrigger {
    @Scheduled(cron = "*/5 * * * * *")
    public void tick() throws Exception {
        System.out.println("tick");
    }
}
