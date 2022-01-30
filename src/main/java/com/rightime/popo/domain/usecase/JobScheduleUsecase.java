package com.rightime.popo.domain.usecase;


import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.entity.JobSchedule;
import com.rightime.popo.domain.entity.Site;
import com.rightime.popo.domain.repo.JobScheduleRepo;
import com.rightime.popo.presenter.BasicBoard;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

public class JobScheduleUsecase {
    private JobScheduleRepo jobScheduleRepo;
    public JobSchedule[] jobSchedules;

    public JobScheduleUsecase(JobScheduleRepo jobScheduleRepo) {
        this.jobScheduleRepo = jobScheduleRepo;
        this.jobSchedules = jobScheduleRepo.load();
    }

    public CrawlJob[] getJobsOnSchedule(Date date) {
        return null;
    }
}
