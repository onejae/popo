package com.rightime.popo.domain.repo;

import com.rightime.popo.domain.entity.JobSchedule;

public interface JobScheduleRepo {
    public JobSchedule[] load();

    public boolean store(JobSchedule jobSchedule);
}