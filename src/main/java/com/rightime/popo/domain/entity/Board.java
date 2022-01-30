package com.rightime.popo.domain.entity;

public abstract class Board implements CrawlJob {
    public String name;
    public String url;
    private String pageParamName;
    public int workingPageNum;

    public String getPageParamName() {
        return pageParamName;
    }

    public void setPageParamName(String pageParamName) {
        this.pageParamName = pageParamName;
    }

    public Board() {

    }

    public Board(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
