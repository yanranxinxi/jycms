package com.cms.jycms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class NewsInfo implements Serializable {
    private int id;

    private String title;

    private Integer classId;

    private String content;

    private String comeFrom;
    private String enTitle;
    private String enContent;
    private String enComeFrom;
    private String enDescription;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime addDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    private Boolean isDel;

    private String className;

    private String imageUrl;

    private String description;

    private int recommend;

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

    public LocalDateTime getAddDate() {
        return addDate;
    }

    public NewsInfo setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
        return this;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public NewsInfo setUpdateDate(LocalDateTime updateDate) {
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

    public String getDescription() {
        return description;
    }

    public NewsInfo setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public NewsInfo setEnTitle(String enTitle) {
        this.enTitle = enTitle;
        return this;
    }

    public String getEnContent() {
        return enContent;
    }

    public NewsInfo setEnContent(String enContent) {
        this.enContent = enContent;
        return this;
    }

    public String getEnComeFrom() {
        return enComeFrom;
    }

    public NewsInfo setEnComeFrom(String enComeFrom) {
        this.enComeFrom = enComeFrom;
        return this;
    }

    public String getEnDescription() {
        return enDescription;
    }

    public NewsInfo setEnDescription(String enDescription) {
        this.enDescription = enDescription;
        return this;
    }

    public int getRecommend() {
        return recommend;
    }

    public NewsInfo setRecommend(int recommend) {
        this.recommend = recommend;
        return this;
    }
}