package com.rightime.popo.controllers;

import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.entity.Crawler;
import com.rightime.popo.domain.service.MessageHandler;
import com.rightime.popo.domain.service.MessageService;
import com.rightime.popo.domain.usecase.CrawlUsecase;
import org.springframework.stereotype.Component;

@Component
public class JobWorker implements MessageHandler {

    private CrawlUsecase crawlUsecase;
    private MessageService messageService;

    public JobWorker(MessageService messageService) {
        this.messageService = messageService;
        this.messageService.setHandler("jobs", this);
    }

    @Override
    public void OnMessage(String message) {

    }

    @Override
    public void OnMessage(CrawlJob job) {
        System.out.println(job);
    }
}
