package com.rightime.popo.domain.entity;


import java.util.Date;

public class JobSchedule {
    public String id;
    // crawl, data analysis, ...
    public String type;

    private CrawlJob[] jobList;

    public boolean checkWithDatetime(Date date) {
        return true;
    }
}
