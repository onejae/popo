package com.rightime.popo.domain.usecase;

import com.rightime.popo.domain.entity.CrawlObject;
import com.rightime.popo.domain.entity.PostItem;

import java.util.ArrayList;

public class CrawlUsecase {
    public ArrayList<PostItem> crawlAndStore(CrawlObject crawlObject) {
        return crawlObject.crawl();
    }
}
