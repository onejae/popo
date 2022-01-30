package com.rightime.popo.database;

import com.rightime.popo.domain.entity.JobSchedule;
import com.rightime.popo.domain.repo.JobScheduleRepo;

public class JobscheduleRepoMysql implements JobScheduleRepo {

    @Override
    public JobSchedule[] load() {
        return new JobSchedule[0];
    }

    @Override
    public boolean store(JobSchedule jobSchedule) {
        return false;
    }
}
