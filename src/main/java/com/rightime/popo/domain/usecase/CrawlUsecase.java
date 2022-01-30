package com.rightime.popo.domain.usecase;

import com.rightime.popo.domain.entity.CrawlJob;
import org.springframework.stereotype.Service;

@Service
public class CrawlUsecase {
    public void startCrawl(CrawlJob crawlJob) {
        crawlJob.crawl();
    }
}
