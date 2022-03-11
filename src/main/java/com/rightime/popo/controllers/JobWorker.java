package com.rightime.popo.controllers;

import com.rightime.popo.domain.entity.Crawler;
import com.rightime.popo.domain.usecase.CrawlUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobWorker {

    @Autowired
    private CrawlUsecase crawlUsecase;

    public void assignJob(Crawler job) {
        crawlUsecase.crawlAndStore(job);
    }
}
