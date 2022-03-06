package com.rightime.popo.presenter.repo;

import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.entity.JobSchedule;
import com.rightime.popo.domain.repo.JobScheduleRepo;
import com.rightime.popo.presenter.db.dto.JobData;
import com.rightime.popo.presenter.db.mapper.JobMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;

@Repository
public class JobScheduleRepoMysql implements JobScheduleRepo {

    @Resource
    private JobMapper jobMapper;

    @Override
    public JobSchedule[] load() {
        return new JobSchedule[0];
    }

    @Override
    public boolean store(JobSchedule jobSchedule) {
        return false;
    }

    @Override
    public CrawlJob[] findJobsEnabled() {
        // create dto from database
        ArrayList<JobData> jobs = jobMapper.findJobByAvailability(true);

        // map dto to entity

        // sample jobs

//        CrawlJob sampleJobs[] = new CrawlJob[1];

//        sampleJobs[0] = new HuvUtza("utza", "http://web.humoruniv.com/board/humor/list.html?table=pds", "pg", 0);

        return null;
    }
}
