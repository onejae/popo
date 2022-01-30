package com.rightime.popo.presenter;

import com.rightime.popo.domain.entity.Board;

public class BasicBoard extends Board {
    public BasicBoard() {
        super();
    }

    public BasicBoard(String name, String url) {
        super(name, url);
    }

    @Override
    public void crawl() {
        System.out.println("Basic board starts to crawling");
        System.out.println(this.url);
    }
}
