package com.rightime.popo.domain.usecase;


import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.entity.JobSchedule;
import com.rightime.popo.domain.repo.JobScheduleRepo;

import java.util.Date;

public class JobScheduleUsecase {
    private JobScheduleRepo jobScheduleRepo;
    public JobSchedule[] jobSchedules;

    public JobScheduleUsecase(JobScheduleRepo jobScheduleRepo) {
        this.jobScheduleRepo = jobScheduleRepo;
        this.jobSchedules = jobScheduleRepo.load();
    }

    public CrawlJob[] findJobsOnSchedule(Date date) {
        CrawlJob[] jobs = jobScheduleRepo.findJobsEnabled(date);

        return jobs;
    }
}
