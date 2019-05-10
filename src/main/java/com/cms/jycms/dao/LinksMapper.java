package com.cms.jycms.dao;

import com.cms.jycms.domain.Links;

import java.util.List;
import java.util.Map;

public interface LinksMapper {
    int insert(Links model);
    int delete(List<String> ids);
    int update(Links model);
    List<Links> selectAll(Map<String,Object> query);
    int selectCount(Map<String,Object> query);
    Links selectById(int id);
}
