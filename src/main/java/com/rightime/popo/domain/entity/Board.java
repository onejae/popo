package com.rightime.popo.domain.entity;

public abstract class Board implements Crawler {
    public String name;
    public String url;
    public String method;
    public String pageParamName;
    public int workingPage;

    public Board() {

    }

    public Board(String name, String url) {
        this.name = name;
        this.url = url;
        this.method = "GET";
    }

    public Board(String name, String url, String pageParamName, int startPage) {
        this(name, url);

        this.pageParamName = pageParamName;
        this.workingPage = startPage;
    }
}
