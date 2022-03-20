package com.rightime.popo.controllers;

import com.rightime.popo.broker.KafkaMessageService;
import com.rightime.popo.domain.usecase.JobScheduleUsecase;
import com.rightime.popo.presenter.repo.JobScheduleRepoMysql;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    public EventTrigger(JobScheduleRepoMysql jobScheduleRepoMysql, KafkaMessageService kafkaMessageService) {
        this.jobScheduleUsecase = new JobScheduleUsecase(jobScheduleRepoMysql, kafkaMessageService);
    }
}