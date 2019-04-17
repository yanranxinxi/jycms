package com.cms.jycms.domain;

public class ResultModel {
    private Integer code;
    private Integer count;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public ResultModel setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public ResultModel setCount(Integer count) {
        this.count = count;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultModel setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResultModel setData(Object data) {
        this.data = data;
        return this;
    }
}
