package com.cms.jycms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewsInfo implements Serializable {
    private String id;

    private String title;

    private Integer classId;

    private String content;

    private String comeFrom;

    private LocalDateTime addDate;
    private LocalDateTime updateDate;

    private Boolean isDel;

    private String className;

    public String getId() {
        return id;
    }

    public NewsInfo setId(String id) {
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
        if (addDate != null) {
            return addDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
        return "";
    }

    public NewsInfo setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
        return this;
    }

    public String getUpdateDate() {
        if (updateDate != null) {
            return updateDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
        return "";
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
}