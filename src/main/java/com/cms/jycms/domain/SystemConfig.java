package com.cms.jycms.domain;

public class SystemConfig {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public SystemConfig setKey(String key) {
        this.key = key;
        return this;
    }

    public String getValue() {
        return value;
    }

    public SystemConfig setValue(String value) {
        this.value = value;
        return this;
    }
}
