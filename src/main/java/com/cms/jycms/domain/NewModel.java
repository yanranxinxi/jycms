package com.cms.jycms.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * @Auther: xuzhenxing
 * @Date: 2019/3/11 16:22
 * @Description:
 */
public class NewModel {
    private int id;
    private String title;
    private String content;
    private int classId;
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime addDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    public int getId() {
        return id;
    }

    public NewModel setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NewModel setContent(String content) {
        this.content = content;
        return this;
    }

    public int getClassId() {
        return classId;
    }

    public NewModel setClassId(int classId) {
        this.classId = classId;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public NewModel setAuthor(String author) {
        this.author = author;
        return this;
    }

    public LocalDateTime getAddDate() {
        return addDate;
    }

    public NewModel setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
        return this;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public NewModel setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
        return this;
    }
}
