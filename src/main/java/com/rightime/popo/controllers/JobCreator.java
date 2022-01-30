package com.rightime.popo.controllers;

import com.rightime.popo.broker.EventProducer;
import com.rightime.popo.database.JobscheduleRepoMysql;
import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.entity.Site;
import com.rightime.popo.domain.usecase.CrawlUsecase;
import com.rightime.popo.domain.usecase.JobScheduleUsecase;
import com.rightime.popo.presenter.BasicBoard;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JobCreator {
    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private CrawlUsecase crawlUsecase;

    private JobScheduleUsecase jobScheduleUsecase;

    private ArrayList<Site> siteList;


    public JobCreator() {
//        mock data
        this.siteList = new ArrayList<Site>();

        // In actual model, read site information from database, and translate it into entity,
        // VO to entity


        this.jobScheduleUsecase = new JobScheduleUsecase(new JobscheduleRepoMysql());

//        this.siteList.add(huv);
    }

    public void createJob() {
        // check job schedule
        CrawlJob[] jobs = jobScheduleUsecase.getJobsOnSchedule(new Date());

        if (jobs != null) {
            for (CrawlJob job : jobs) {
                if (job != null) {
                    eventProducer.sendMessage(job);
                }
            }
        }
    }
}

