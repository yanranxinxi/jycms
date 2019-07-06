package com.cms.jycms.dto;

import java.util.List;

public class NavClassDTO {
    private int id;
    private String className;
    private String url;
    private List<NavClassDTO> secondClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<NavClassDTO> getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(List<NavClassDTO> secondClass) {
        this.secondClass = secondClass;
    }
}
