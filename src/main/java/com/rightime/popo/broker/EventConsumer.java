package com.rightime.popo.broker;

import com.rightime.popo.domain.entity.CrawlJob;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;


@Configuration
class EventConsumerConfig {
    @Value("${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value("${kafka.topics.trigger.name}")
    private String triggerTopicName;

    @Value("${kafka.topics.job.name}")
    private String jobTopicName;

    @Value("${kafka.topics.trigger.group.id}")
    private String triggerGroupId;

    @Value("${kafka.topics.job.group.id}")
    private String jobGroupId;


    @Bean
    public ConsumerFactory<String, CrawlJob> crawlJobConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, jobGroupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CrawlJob>
    crawlJobKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CrawlJob> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConcurrency(3);  // the number of consumers
        factory.setConsumerFactory(crawlJobConsumerFactory());
        return factory;
    }
}