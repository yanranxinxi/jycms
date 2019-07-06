package com.cms.jycms.dao;

import com.cms.jycms.domain.ClassInfo;

import java.util.List;

public interface ClassInfoMapper {
    List<ClassInfo> selectAll();
    List<ClassInfo> getNav();
    List<ClassInfo> getNavByParentId(int parentId);
    List<ClassInfo> getNavSubClassByParentId(int parentId);
    int delete(int id);
    int update(ClassInfo model);
    int insert(ClassInfo model);
    ClassInfo selectById(int id);
}