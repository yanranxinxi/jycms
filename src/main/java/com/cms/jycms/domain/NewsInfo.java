package com.cms.jycms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewsInfo implements Serializable {
    private int id;

    private String title;

    private Integer classId;

    private String content;

    private String comeFrom;

    private String addDate;
    private String updateDate;

    private Boolean isDel;

    private String className;

    private String imageUrl;

    public int getId() {
        return id;
    }

    public NewsInfo setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NewsInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getClassId() {
        return classId;
    }

    public NewsInfo setClassId(Integer classId) {
        this.classId = classId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NewsInfo setContent(String content) {
        this.content = content;
        return this;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public NewsInfo setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
        return this;
    }

    public String getAddDate() {
        return addDate;
    }

    public NewsInfo setAddDate(String addDate) {
        this.addDate = addDate;
        return this;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public NewsInfo setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public Boolean getDel() {
        return isDel;
    }

    public NewsInfo setDel(Boolean del) {
        isDel = del;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public NewsInfo setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public NewsInfo setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}