package com.rightime.popo.domain.entity;


import java.util.Date;

public class CrawlJob {
    public int id;
    public int jobObjectId;

    public boolean checkWithDatetime(Date date) {
        return true;
    }
}
