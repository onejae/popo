package com.rightime.popo.domain.usecase;


import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.entity.CrawlObject;
import com.rightime.popo.domain.repo.CrawlObjectRepo;
import com.rightime.popo.domain.repo.JobScheduleRepo;
import com.rightime.popo.domain.service.MessageService;

import java.util.Date;
import java.util.stream.Stream;

public class JobScheduleUsecase {
    public JobScheduleRepo getJobScheduleRepo() {
        return jobScheduleRepo;
    }

    private JobScheduleRepo jobScheduleRepo;
    private CrawlObjectRepo crawlObjectRepo;
    private MessageService messageService;

    public JobScheduleUsecase(JobScheduleRepo jobScheduleRepo, MessageService messageService, CrawlObjectRepo crawlObjectRepo) {
        this.jobScheduleRepo = jobScheduleRepo;
        this.messageService = messageService;
        this.crawlObjectRepo = crawlObjectRepo;
    }

    public CrawlJob[] startJobsOnSchedule(Date date) {
        CrawlJob[] crawlJobs = jobScheduleRepo.findJobsEnabled();
        Stream.of(crawlJobs).forEach(job -> messageService.appendJob(job));

        return crawlJobs;
    }

    public CrawlObject getCrawlObjectById(int jobObjectId) {
        CrawlObject crawlObject = crawlObjectRepo.getObjectById(jobObjectId);

        return crawlObject;
    }
}