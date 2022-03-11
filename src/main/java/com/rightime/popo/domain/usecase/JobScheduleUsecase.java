package com.rightime.popo.domain.usecase;


import com.rightime.popo.domain.entity.Crawler;
import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.repo.JobScheduleRepo;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JobScheduleUsecase {
    public JobScheduleRepo getJobScheduleRepo() {
        return jobScheduleRepo;
    }

    public JobScheduleRepo jobScheduleRepo;
    public CrawlJob[] crawlJobs;
//    public MessageService messageService;

//    public JobScheduleUsecase(JobScheduleRepo jobScheduleRepo) {
//        this.jobScheduleRepo = jobScheduleRepo;
//        this.jobSchedules = jobScheduleRepo.load();
//    }

    public Crawler[] startJobsOnSchedule(Date date) {
        CrawlJob[] jobs = jobScheduleRepo.findJobsEnabled();

        // at this stage, all enabled jobs will be executed, just ignoring schedule
        if (jobs == null) {
            return null;
        }

        for (CrawlJob job : jobs) {
//            messageService.BroadcastJob(job);
        }

        return null;
    }
}
