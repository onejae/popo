package com.rightime.popo.domain.repo;


import com.rightime.popo.domain.entity.CrawlObject;

public interface CrawlObjectRepo {
    public CrawlObject save(CrawlObject board);

    public CrawlObject getObjectById(int id);
}