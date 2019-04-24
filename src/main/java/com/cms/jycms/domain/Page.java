package com.cms.jycms.domain;

public class Page {
    private  int  totalPages;
    private int number;

    public int getTotalPages() {
        return totalPages;
    }

    public Page setTotalPages(int totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Page setNumber(int number) {
        this.number = number;
        return this;
    }
}
