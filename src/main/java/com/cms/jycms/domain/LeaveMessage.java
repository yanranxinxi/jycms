package com.cms.jycms.domain;

import java.time.LocalDateTime;

public class LeaveMessage {
    private int id;
    private String customName;
    private String telNo;
    private String message;
    private LocalDateTime addDate;

    public int getId() {
        return id;
    }

    public LeaveMessage setId(int id) {
        this.id = id;
        return this;
    }

    public String getCustomName() {
        return customName;
    }

    public LeaveMessage setCustomName(String customName) {
        this.customName = customName;
        return this;
    }

    public String getTelNo() {
        return telNo;
    }

    public LeaveMessage setTelNo(String telNo) {
        this.telNo = telNo;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public LeaveMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getAddDate() {
        return addDate;
    }

    public LeaveMessage setAddDate(LocalDateTime addDate) {
        this.addDate = addDate;
        return this;
    }
}
