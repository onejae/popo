package com.rightime.popo.domain.service;

import com.rightime.popo.domain.entity.CrawlJob;

public interface MessageService {
    void Broadcast(String message);

    void SendTo(String to, String message);

    void BroadcastJob(CrawlJob job);
}
