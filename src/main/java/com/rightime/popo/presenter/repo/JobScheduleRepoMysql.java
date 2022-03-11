package com.rightime.popo.presenter.repo;

import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.repo.JobScheduleRepo;
import com.rightime.popo.presenter.db.dto.JobData;
import com.rightime.popo.presenter.db.dto.ModelMapper;
import com.rightime.popo.presenter.db.mapper.JobMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;

@Repository
public class JobScheduleRepoMysql implements JobScheduleRepo {

    @Resource
    private JobMapper jobMapper;

    @Override
    public CrawlJob[] load() {
        return new CrawlJob[0];
    }

    @Override
    public boolean store(CrawlJob crawlJob) {
        return false;
    }

    @Override
    public CrawlJob[] findJobsEnabled() {
        ArrayList<JobData> jobDataArrayList = jobMapper.findJobByAvailability(true);

        CrawlJob[] crawlJobs = new CrawlJob[jobDataArrayList.size()];

        int i = 0;

        for (JobData jobData : jobDataArrayList) {
            crawlJobs[i++] = ModelMapper.INSTANCE.JobDataToEntity(jobData);
        }

        return crawlJobs;
    }
}
