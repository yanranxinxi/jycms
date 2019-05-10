package com.cms.jycms.component;

import com.cms.jycms.domain.ClassInfo;
import com.cms.jycms.domain.Links;
import com.cms.jycms.domain.NewsInfo;
import com.cms.jycms.dto.PaginationDTO;
import com.cms.jycms.dto.ViewClassListDTO;
import com.cms.jycms.dto.WebSiteBaseInfoDTO;
import com.cms.jycms.service.ClassInfoService;
import com.cms.jycms.service.LinksService;
import com.cms.jycms.service.NewsInfoService;
import com.cms.jycms.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PubComponent {
    @Autowired
    private SystemConfigService systemConfigService;

    @Autowired
    private NewsInfoService newsInfoService;

    @Autowired
    private ClassInfoService classInfoService;

    @Autowired
    private LinksService linksService;

    /**
     * 获取基础信息
     *
     * @return
     */
    public WebSiteBaseInfoDTO getBaseInfo() {
        String copyright = systemConfigService.select("copyright");
        String title = systemConfigService.select("title");
        String keyword = systemConfigService.select("keyword");
        String description = systemConfigService.select("description");
        String leftContactUs = systemConfigService.select("leftContactUs");

        String enCopyright = systemConfigService.select("enCopyright");
        String enTitle = systemConfigService.select("enTitle");
        String enKeyword = systemConfigService.select("enKeyword");
        String enDescription = systemConfigService.select("enDescription");
        String enLeftContactUs = systemConfigService.select("enLeftContactUs");
        String tel = systemConfigService.select("tel");

        Map<String, Object> linksMap = new HashMap();
        linksMap.put("offset", 0);
        linksMap.put("pageSize", 20);
        List<Links> linksList = linksService.selectAll(linksMap);

        WebSiteBaseInfoDTO dto = new WebSiteBaseInfoDTO();
        dto.setCopyright(copyright);
        dto.setDescription(description);
        dto.setKeyword(keyword);
        dto.setLeftContactUs(leftContactUs);
        dto.setTitle(title);
        dto.setEnTitle(enTitle);
        dto.setEnDescription(enDescription);
        dto.setEnKeyword(enKeyword);
        dto.setEnCopyright(enCopyright);
        dto.setEnLeftContactUs(enLeftContactUs);
        dto.setTel(tel);
        dto.setLinksList(linksList);
        return dto;
    }

    /**
     * 获取单类列表
     *
     * @param classId  分类ID
     * @param offset   开始的序号
     * @param pageSize 页码大小
     * @return
     */
    public List<NewsInfo> getArtList(int classId, int offset, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("classId", classId);
        map.put("offset", offset);
        map.put("pageSize", pageSize);
        List<NewsInfo> list = newsInfoService.selectAll(map);
        return list;
    }

    /**
     * 获取侧边列表(一级、二级)
     *
     * @param classId   父分类ID
     * @param limit     条数
     * @param recommend 是否是推荐信息,0：否，1：是
     * @return
     */
    public List<NewsInfo> getSide(int classId, int limit, int recommend) {
        Map<String, Object> newsInfoMap = new HashMap<>();
        newsInfoMap.put("limit", limit);
        newsInfoMap.put("classId", classId);
        newsInfoMap.put("recommend", recommend);
        List<NewsInfo> newsList = newsInfoService.selectByClassId(newsInfoMap);
        return newsList;
    }

    /**
     * 获取分类列表信息
     *
     * @param classId   分类ID
     * @param pageIndex 页码
     * @param pageSize  页码大小
     * @return
     */
    public PaginationDTO getPaginationInfo(int classId, int pageIndex, int pageSize) {
        PaginationDTO model = new PaginationDTO();
        Map<String, Object> map = new HashMap<>();
        map.put("offset", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("classId", classId);
        List<NewsInfo> artList = newsInfoService.selectAll(map);
        int total = newsInfoService.selectCount(map);
        int totalPages = total / pageSize;
        if ((total % pageSize) > 0) {
            totalPages++;
        }
        model.setArtList(artList);
        model.setPageIndex(pageIndex);
        model.setTotalPages(totalPages);
        return model;
    }

    /**
     * 获取二级页面产品或新闻信息
     *
     * @param proClassId    主分类ID
     * @param proPageIndex  主分类开始页码
     * @param proPageSize   主分类页码大小
     * @param sideClassId   侧边栏分类ID
     * @param sideLimit     侧边栏条数
     * @param sideRecommend 侧边栏是否是推荐信息
     * @return
     */
    public ViewClassListDTO viewClassList(int proClassId, int proPageIndex, int proPageSize, int sideClassId, int sideLimit, int sideRecommend) {
        //获取网站基础信息
        WebSiteBaseInfoDTO webSiteBaseInfoDTO = getBaseInfo();
        //获取产品分类列表
        List<ClassInfo> productTypeList = classInfoService.getNavByParentId(30);
        //获取侧边新闻列表
        List<NewsInfo> newsList = getSide(sideClassId, sideLimit, sideRecommend);
        //产品
        PaginationDTO paginationDTO = getPaginationInfo(proClassId, proPageIndex, proPageSize);

        ViewClassListDTO dto = new ViewClassListDTO();
        dto.setWebSiteBaseInfoDTO(webSiteBaseInfoDTO);
        dto.setProductTypeList(productTypeList);
        dto.setNewsList(newsList);
        dto.setPaginationDTO(paginationDTO);
        return dto;
    }
}
