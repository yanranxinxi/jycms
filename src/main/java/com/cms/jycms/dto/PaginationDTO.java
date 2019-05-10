package com.cms.jycms.dto;

import com.cms.jycms.domain.NewsInfo;

import java.util.List;

public class PaginationDTO {
    private List<NewsInfo> artList;
    private int totalPages;
    private int pageIndex;

    public List<NewsInfo> getArtList() {
        return artList;
    }

    public PaginationDTO setArtList(List<NewsInfo> artList) {
        this.artList = artList;
        return this;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public PaginationDTO setTotalPages(int totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public PaginationDTO setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }
}
