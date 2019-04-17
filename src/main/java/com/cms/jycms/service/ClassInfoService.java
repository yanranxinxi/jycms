package com.cms.jycms.service;

import com.cms.jycms.dao.ClassInfoMapper;
import com.cms.jycms.domain.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassInfoService {
    @Autowired
    private ClassInfoMapper mapper;

    public List<ClassInfo> selectAll()
    {
        return mapper.selectAll();
    }
}
