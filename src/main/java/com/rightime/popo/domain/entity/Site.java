package com.rightime.popo.domain.entity;

import java.util.ArrayList;

public class Site implements CrawlJob {
    public String url;
    public String name;
    private ArrayList<Board> boardList;

    public Site(String name, String url) {
        this.name = name;
        this.url = url;

        this.boardList = new ArrayList<>();
    }

    public void addBoard(Board board) {
        this.boardList.add(board);
    }

    public void crawl() {
        for (Board board : this.boardList) {
            board.crawl();
        }
    }
}
