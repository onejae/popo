package com.rightime.popo.domain.usecase;

import com.rightime.popo.domain.entity.Crawler;
import com.rightime.popo.domain.entity.PostItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CrawlUsecase {
    public void crawlAndStore(Crawler crawler) {
        ArrayList<PostItem> postItemArrayList = crawler.crawl();
    }
}
