package com.rightime.popo.presenter;

import com.rightime.popo.domain.entity.Board;

public class HuvUtza extends Board {
    public HuvUtza() {
        super();
    }

    public HuvUtza(String name, String url) {
        super(name, url);
    }

    public HuvUtza(String name, String url, String pageParamName, int startPage) {
        super(name, url, pageParamName, startPage);
    }

    @Override
    public void crawl() {
        System.out.println("Basic board starts to crawling");
        System.out.println(this.url);

        
    }
}
