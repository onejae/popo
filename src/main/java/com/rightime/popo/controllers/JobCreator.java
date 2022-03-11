package com.rightime.popo.controllers;

import com.rightime.popo.broker.EventProducer;
import com.rightime.popo.domain.entity.Crawler;
import com.rightime.popo.domain.entity.Site;
import com.rightime.popo.domain.usecase.JobScheduleUsecase;
import com.rightime.popo.presenter.repo.JobScheduleRepoMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class JobCreator {
    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private JobScheduleUsecase jobScheduleUsecase;

    private ArrayList<Site> siteList;


    @Autowired
    public void setRepo(JobScheduleRepoMysql jobScheduleRepoMysql) {
        this.jobScheduleUsecase.jobScheduleRepo = jobScheduleRepoMysql;
    }

    public JobCreator() {
        this.siteList = new ArrayList<>();
    }

    public void createJob() {
        // check job schedule
        Crawler[] jobs = jobScheduleUsecase.startJobsOnSchedule(new Date());

        if (jobs != null) {
            for (Crawler job : jobs) {
                if (job != null) {
                    eventProducer.sendMessage(job);
                }
            }
        }
    }
}

