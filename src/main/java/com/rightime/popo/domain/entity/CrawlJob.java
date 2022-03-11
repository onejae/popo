package com.rightime.popo.domain.entity;


import java.util.Date;

public class CrawlJob {
    public int id;
    public String jobType;

    private Crawler[] jobList;

    public boolean checkWithDatetime(Date date) {
        return true;
    }
}
