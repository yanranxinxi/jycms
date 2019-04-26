package com.cms.jycms.dto;

public class BatchContentDTO {

    private Integer classId;

    private ImageNameDTO files[];

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public ImageNameDTO[] getFiles() {
        return files;
    }

    public void setFiles(ImageNameDTO[] files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "BatchContentDTO{" +
                "classId=" + classId +
                ", files=" + files +
                '}';
    }
}
