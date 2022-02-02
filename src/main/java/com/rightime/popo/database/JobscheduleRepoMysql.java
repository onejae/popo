package com.rightime.popo.database;

import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.entity.JobSchedule;
import com.rightime.popo.domain.repo.JobScheduleRepo;
import com.rightime.popo.presenter.HuvUtza;

import java.util.Date;

public class JobScheduleRepoMysql implements JobScheduleRepo {

    @Override
    public JobSchedule[] load() {
        return new JobSchedule[0];
    }

    @Override
    public boolean store(JobSchedule jobSchedule) {
        return false;
    }

    @Override
    public CrawlJob[] findJobsEnabled(Date date) {
        // sample jobs
        CrawlJob sampleJobs[] = new CrawlJob[1];

        sampleJobs[0] = new HuvUtza("utza", "http://web.humoruniv.com/board/humor/list.html?table=pds", "pg", 0);

        return sampleJobs;
    }
}
