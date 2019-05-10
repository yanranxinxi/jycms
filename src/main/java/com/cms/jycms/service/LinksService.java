package com.cms.jycms.service;

import com.cms.jycms.dao.LinksMapper;
import com.cms.jycms.domain.Links;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LinksService {
    @Autowired
    private LinksMapper mapper;

    public int insert(Links model) {
        return mapper.insert(model);
    }

    public int delete(List<String> ids) {
        return mapper.delete(ids);
    }

    public int update(Links model) {
        return mapper.update(model);
    }

    public List<Links> selectAll(Map<String, Object> query) {
        return mapper.selectAll(query);
    }

    public int selectCount(Map<String, Object> query) {
        return mapper.selectCount(query);
    }

    public Links selectById(int id) {
        return mapper.selectById(id);
    }
}
