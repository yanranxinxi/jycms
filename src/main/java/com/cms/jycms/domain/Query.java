package com.cms.jycms.domain;

public class Query {
    private Integer offset;
    private Integer pageSize;

    public Query(Integer page, Integer pageSize) {
        setOffset((page - 1) * pageSize);
        setPageSize(pageSize);
    }

    public Integer getOffset() {
        return offset;
    }

    public Query setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Query setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
