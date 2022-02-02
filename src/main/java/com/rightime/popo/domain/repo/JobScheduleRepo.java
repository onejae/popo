package com.rightime.popo.domain.repo;

import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.entity.JobSchedule;

import java.util.Date;

public interface JobScheduleRepo {
    public JobSchedule[] load();

    public boolean store(JobSchedule jobSchedule);

    public CrawlJob[] findJobsEnabled(Date date);
}