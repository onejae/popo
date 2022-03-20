package com.rightime.popo.broker;

import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.service.MessageHandler;
import com.rightime.popo.domain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class KafkaMessageService implements MessageService {
    private HashMap<String, MessageHandler> handlerMap;

    @Autowired
    private KafkaTemplate<String, CrawlJob> crawlJobKafkaTemplate;

    @Value(value = "${kafka.topics.trigger.name}")
    private String triggerTopicName;

    @Value(value = "${kafka.topics.job.name}")
    private String jobTopicName;

    @Override
    public void broadcast(String message) {
//        kafkaTemplate.send(triggerTopicName, message);
    }

    @Override
    public void sendTo(String to, String message) {
    }

    @Override
    public void appendJob(CrawlJob job) {
        crawlJobKafkaTemplate.send(jobTopicName, "key", job);
    }

    @Override
    public void setHandler(String eventName, MessageHandler messageHandler) {
        this.handlerMap.put(eventName, messageHandler);
    }

    public KafkaMessageService() {
        this.handlerMap = new HashMap<String, MessageHandler>();
    }

    @KafkaListener(topics = "${kafka.topics.job.name}", id = "${kafka.topics.job.group.id}", containerFactory = "crawlJobKafkaListenerContainerFactory")
    public void kafkaListener(CrawlJob job) {
        MessageHandler handler = this.handlerMap.get(jobTopicName);
        handler.OnMessage(job);
    }
}
