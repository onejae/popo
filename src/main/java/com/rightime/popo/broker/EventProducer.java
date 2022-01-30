package com.rightime.popo.broker;

import org.springframework.kafka.support.serializer.JsonSerializer;
import com.rightime.popo.domain.entity.CrawlJob;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Configuration
class EventProducerConfig {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    private KafkaTemplate<String, String> template;

    // kafka template for string
    @Bean
    public ProducerFactory<String, String> basicProducerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, String> basicKafkaTemplate() {
        return new KafkaTemplate<>(basicProducerFactory());
    }

    // kafka template for job
    @Bean
    public ProducerFactory<String, CrawlJob> crawlJobProducerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, CrawlJob> crawlJobKafkaTemplate() {
        return new KafkaTemplate(crawlJobProducerFactory());
    }
}

@Service
public class EventProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, CrawlJob> crawlJobKafkaTemplate;

    @Value(value = "${kafka.topics.trigger.name}")
    private String triggerTopicName;

    @Value(value = "${kafka.topics.job.name}")
    private String jobTopicName;

    public void sendMessage(String message) {
        kafkaTemplate.send(triggerTopicName, message);
    }

    public void sendMessage(CrawlJob job) {
        crawlJobKafkaTemplate.send(jobTopicName, job);
    }
}
