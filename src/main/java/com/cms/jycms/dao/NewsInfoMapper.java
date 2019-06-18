package com.cms.jycms.dao;

import com.cms.jycms.domain.NewsInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface NewsInfoMapper {
    NewsInfo selectByPrimaryKey(String id);

    List<NewsInfo> selectAll(Map<String, Object> query);

    List<NewsInfo> selectByClassId(Map<String, Object> query);

    String selectChild(int classId);

    List<NewsInfo> selectArtByClassId(HashMap<String,Object> map);
    int selectArtByClassIdCount(HashMap<String,Object> map);

    int selectCount(Map<String, Object> query);

    int delByIds(List<String> ids);

    int updateRecommendByIds(List<String> ids);

    int addContent(NewsInfo model);

    int updateContent(NewsInfo model);

    List<NewsInfo> selectUpDown(NewsInfo model);
}