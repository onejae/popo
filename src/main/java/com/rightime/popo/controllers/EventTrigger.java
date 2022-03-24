package com.rightime.popo.controllers;

import com.rightime.popo.broker.KafkaMessageService;
import com.rightime.popo.domain.usecase.JobScheduleUsecase;
import com.rightime.popo.presenter.repo.CrawlObjectRepoMysql;
import com.rightime.popo.presenter.repo.JobScheduleRepoMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EventTrigger {
    private JobScheduleUsecase jobScheduleUsecase;

    @Scheduled(cron = "*/1 * * * * *")
    public void tick() throws Exception {
        jobScheduleUsecase.startJobsOnSchedule(new Date());
    }

    @Bean
    @Autowired
    public JobScheduleUsecase createJobScheduleUsecase(JobScheduleRepoMysql jobScheduleRepoMysql, CrawlObjectRepoMysql crawlObjectRepoMysql, KafkaMessageService kafkaMessageService) {
        return this.jobScheduleUsecase;
    }

    @Autowired
    public EventTrigger(JobScheduleRepoMysql jobScheduleRepoMysql, CrawlObjectRepoMysql crawlObjectRepoMysql, KafkaMessageService kafkaMessageService) {
        this.jobScheduleUsecase = new JobScheduleUsecase(jobScheduleRepoMysql, kafkaMessageService, crawlObjectRepoMysql);
    }
}