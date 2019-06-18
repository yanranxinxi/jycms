package com.cms.jycms.service;

import com.cms.jycms.dao.NewsInfoMapper;
import com.cms.jycms.domain.NewsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsInfoService {
    @Autowired
    private NewsInfoMapper mapper;

    public NewsInfo selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<NewsInfo> selectAll(Map<String, Object> query) {
        return mapper.selectAll(query);
    }

    public List<NewsInfo> selectByClassId(Map<String, Object> query) {
        return mapper.selectByClassId(query);
    }

    public String selectChild(int classId) {
        return mapper.selectChild(classId);
    }

    public List<NewsInfo> selectArtByClassId(String classIds, int limit) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("classIds", classIds);
        map.put("limit", limit);
        return mapper.selectArtByClassId(map);
    }

    public List<NewsInfo> selectArtByClassId(String classIds, int limit, int pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("classIds", classIds);
        map.put("limit", limit);
        map.put("pageSize", pageSize);
        return mapper.selectArtByClassId(map);
    }

    public int selectArtByClassIdCount(String classIds) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("classIds", classIds);
        return mapper.selectArtByClassIdCount(map);
    }

    public int selectCount(Map<String, Object> query) {
        return mapper.selectCount(query);
    }

    public int delByIds(List<String> ids) {
        return mapper.delByIds(ids);
    }

    public int updateRecommendByIds(List<String> ids) {
        return mapper.updateRecommendByIds(ids);
    }

    public int addContent(NewsInfo model) {
        return mapper.addContent(model);
    }

    public int updateContent(NewsInfo model) {
        return mapper.updateContent(model);
    }

    public List<NewsInfo> selectUpDown(NewsInfo model) {
        return mapper.selectUpDown(model);
    }
}
