package com.rightime.popo.domain.service;

import com.rightime.popo.domain.entity.CrawlJob;

public interface MessageHandler {
    public void OnMessage(String message);

    public void OnMessage(CrawlJob job);
}
