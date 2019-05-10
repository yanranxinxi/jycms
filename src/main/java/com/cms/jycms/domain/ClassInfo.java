package com.cms.jycms.domain;

public class ClassInfo {
    private int id;
    private String name;
    private int parentId;
    private String url;
    private int order;
    private String keyword;
    private String description;
    private String enName;

    public int getId() {
        return id;
    }

    public ClassInfo setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ClassInfo setName(String name) {
        this.name = name;
        return this;
    }

    public int getParentId() {
        return parentId;
    }

    public ClassInfo setParentId(int parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ClassInfo setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public ClassInfo setOrder(int order) {
        this.order = order;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public ClassInfo setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ClassInfo setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getEnName() {
        return enName;
    }

    public ClassInfo setEnName(String enName) {
        this.enName = enName;
        return this;
    }
}