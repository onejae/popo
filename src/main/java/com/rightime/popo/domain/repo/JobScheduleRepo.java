package com.rightime.popo.domain.repo;

import com.rightime.popo.domain.entity.CrawlJob;

public interface JobScheduleRepo {
    CrawlJob[] load();

    boolean store(CrawlJob crawlJob);

    CrawlJob[] findJobsEnabled();
}