package com.cms.jycms.dto;

import com.cms.jycms.domain.Links;

import java.util.List;

public class WebSiteBaseInfoDTO {
    private String copyright;
    private String title;
    private String keyword;
    private String description;
    private String leftContactUs;
    private String enTitle;
    private String enKeyword;
    private String enDescription;
    private String enLeftContactUs;
    private String enCopyright;
    private String tel;
    private List<Links> linksList;

    public String getCopyright() {
        return copyright;
    }

    public WebSiteBaseInfoDTO setCopyright(String copyright) {
        this.copyright = copyright;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public WebSiteBaseInfoDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public WebSiteBaseInfoDTO setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public WebSiteBaseInfoDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLeftContactUs() {
        return leftContactUs;
    }

    public WebSiteBaseInfoDTO setLeftContactUs(String leftContactUs) {
        this.leftContactUs = leftContactUs;
        return this;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public WebSiteBaseInfoDTO setEnTitle(String enTitle) {
        this.enTitle = enTitle;
        return this;
    }

    public String getEnKeyword() {
        return enKeyword;
    }

    public WebSiteBaseInfoDTO setEnKeyword(String enKeyword) {
        this.enKeyword = enKeyword;
        return this;
    }

    public String getEnDescription() {
        return enDescription;
    }

    public WebSiteBaseInfoDTO setEnDescription(String enDescription) {
        this.enDescription = enDescription;
        return this;
    }

    public String getEnLeftContactUs() {
        return enLeftContactUs;
    }

    public WebSiteBaseInfoDTO setEnLeftContactUs(String enLeftContactUs) {
        this.enLeftContactUs = enLeftContactUs;
        return this;
    }

    public String getEnCopyright() {
        return enCopyright;
    }

    public WebSiteBaseInfoDTO setEnCopyright(String enCopyright) {
        this.enCopyright = enCopyright;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public WebSiteBaseInfoDTO setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public List<Links> getLinksList() {
        return linksList;
    }

    public WebSiteBaseInfoDTO setLinksList(List<Links> linksList) {
        this.linksList = linksList;
        return this;
    }
}
