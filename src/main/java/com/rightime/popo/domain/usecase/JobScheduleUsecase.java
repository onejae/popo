package com.rightime.popo.domain.usecase;


import com.rightime.popo.domain.entity.Crawler;
import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.repo.JobScheduleRepo;
import com.rightime.popo.domain.service.MessageService;

import java.util.Date;

public class JobScheduleUsecase {
    public JobScheduleRepo getJobScheduleRepo() {
        return jobScheduleRepo;
    }

    private JobScheduleRepo jobScheduleRepo;
    private CrawlJob[] crawlJobs;
    private MessageService messageService;

    public JobScheduleUsecase(JobScheduleRepo jobScheduleRepo, MessageService messageService) {
        this.jobScheduleRepo = jobScheduleRepo;
        this.messageService = messageService;
    }

    public Crawler[] startJobsOnSchedule(Date date) {
        CrawlJob[] jobs = jobScheduleRepo.findJobsEnabled();

        // at this stage, all enabled jobs will be executed, just ignoring schedule
        if (jobs == null) {
            return null;
        }

        for (CrawlJob job : jobs) {
            messageService.appendJob(job);
        }

        return null;
    }
}