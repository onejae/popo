package com.rightime.popo.domain.service;

import com.rightime.popo.domain.entity.CrawlJob;


public interface MessageService {
    void broadcast(String message);

    void sendTo(String to, String message);

    void appendJob(CrawlJob job);

    void setHandler(String evnetName, MessageHandler messageHandler);
}


