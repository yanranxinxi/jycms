package com.cms.jycms.domain;

public class Links {
    private int id;
    private String title;
    private String url;
    private String enTitle;

    public int getId() {
        return id;
    }

    public Links setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Links setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Links setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public Links setEnTitle(String enTitle) {
        this.enTitle = enTitle;
        return this;
    }
}
