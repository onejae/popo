package com.rightime.popo.domain.usecase;


import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.entity.JobSchedule;
import com.rightime.popo.domain.repo.JobScheduleRepo;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JobScheduleUsecase {
    public JobScheduleRepo getJobScheduleRepo() {
        return jobScheduleRepo;
    }

    public JobScheduleRepo jobScheduleRepo;
    public JobSchedule[] jobSchedules;

//    public JobScheduleUsecase(JobScheduleRepo jobScheduleRepo) {
//        this.jobScheduleRepo = jobScheduleRepo;
//        this.jobSchedules = jobScheduleRepo.load();
//    }

    public CrawlJob[] findJobsOnSchedule(Date date) {
        CrawlJob[] jobs = jobScheduleRepo.findJobsEnabled();

        System.out.println(jobs);

        // check schedule considering interval
//        for (CrawlJob job : jobs) {
//            if (job.)
//        }
        return jobs;
    }
}
