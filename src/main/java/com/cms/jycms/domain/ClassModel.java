package com.cms.jycms.domain;

/**
 * @Auther: xuzhenxing
 * @Date: 2019/3/11 16:43
 * @Description:
 */
public class ClassModel {
    private int id;
    private String className;
    private String description;
    private int parentId;

    public int getId() {
        return id;
    }

    public ClassModel setId(int id) {
        this.id = id;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public ClassModel setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ClassModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getParentId() {
        return parentId;
    }

    public ClassModel setParentId(int parentId) {
        this.parentId = parentId;
        return this;
    }
}
