package com.cms.jycms.dao;

import com.cms.jycms.domain.ClassInfo;

import java.util.List;

public interface ClassInfoMapper {
    List<ClassInfo> selectAll();
    List<ClassInfo> getNav();
    int delete(int id);
    int update(ClassInfo model);
    int insert(ClassInfo model);
}