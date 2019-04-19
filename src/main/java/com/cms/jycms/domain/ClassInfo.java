package com.cms.jycms.domain;

public class ClassInfo {
    private int id;
    private String name;
    private int parentId;

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
}