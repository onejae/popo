package com.rightime.popo.domain.entity;

public abstract class Board implements CrawlJob {
    public String name;
    public String url;
    private String pageParamName;
    public int workingPage;

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

    public Board(String name, String url, String pageParamName, int startPage) {
        this(name, url);

        this.pageParamName = pageParamName;
        this.workingPage = startPage;
    }
}
