package com.rightime.popo.domain.usecase;

import com.rightime.popo.domain.entity.CrawlJob;
import com.rightime.popo.domain.entity.PostItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CrawlUsecase {
    public void crawlAndStore(CrawlJob crawlJob) {
        ArrayList<PostItem> postItemArrayList = crawlJob.crawl();
    }
}
