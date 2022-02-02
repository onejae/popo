package com.rightime.popo.controllers;

import com.rightime.popo.broker.EventProducer;
import com.rightime.popo.database.JobScheduleRepoMysql;
import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.entity.Site;
import com.rightime.popo.domain.usecase.CrawlUsecase;
import com.rightime.popo.domain.usecase.JobScheduleUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class JobCreator {
    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private CrawlUsecase crawlUsecase;

    private JobScheduleUsecase jobScheduleUsecase;

    private ArrayList<Site> siteList;


    public JobCreator() {
        this.siteList = new ArrayList<Site>();
        this.jobScheduleUsecase = new JobScheduleUsecase(new JobScheduleRepoMysql());
    }

    public void createJob() {
        // check job schedule
        CrawlJob[] jobs = jobScheduleUsecase.findJobsOnSchedule(new Date());

        if (jobs != null) {
            for (CrawlJob job : jobs) {
                if (job != null) {
                    eventProducer.sendMessage(job);
                }
            }
        }
    }
}

