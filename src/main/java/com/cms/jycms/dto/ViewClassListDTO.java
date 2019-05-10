package com.cms.jycms.dto;

import com.cms.jycms.domain.ClassInfo;
import com.cms.jycms.domain.NewsInfo;

import java.util.List;

public class ViewClassListDTO {
    private WebSiteBaseInfoDTO webSiteBaseInfoDTO;
    private List<ClassInfo> productTypeList;
    private List<NewsInfo> newsList;
    private PaginationDTO paginationDTO;

    public WebSiteBaseInfoDTO getWebSiteBaseInfoDTO() {
        return webSiteBaseInfoDTO;
    }

    public ViewClassListDTO setWebSiteBaseInfoDTO(WebSiteBaseInfoDTO webSiteBaseInfoDTO) {
        this.webSiteBaseInfoDTO = webSiteBaseInfoDTO;
        return this;
    }

    public List<ClassInfo> getProductTypeList() {
        return productTypeList;
    }

    public ViewClassListDTO setProductTypeList(List<ClassInfo> productTypeList) {
        this.productTypeList = productTypeList;
        return this;
    }

    public List<NewsInfo> getNewsList() {
        return newsList;
    }

    public ViewClassListDTO setNewsList(List<NewsInfo> newsList) {
        this.newsList = newsList;
        return this;
    }

    public PaginationDTO getPaginationDTO() {
        return paginationDTO;
    }

    public ViewClassListDTO setPaginationDTO(PaginationDTO paginationDTO) {
        this.paginationDTO = paginationDTO;
        return this;
    }
}
