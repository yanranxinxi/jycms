package com.cms.jycms.service;

import com.cms.jycms.dao.SystemConfigMapper;
import com.cms.jycms.domain.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemConfigService {
    @Autowired
    private SystemConfigMapper mapper;

    public int insert(SystemConfig model) {
        return mapper.insert(model);
    }

    public int delete(String key) {
        return mapper.delete(key);
    }

    public int update(SystemConfig model) {
        return mapper.update(model);
    }

    public SystemConfig select(String key) {
        return mapper.select(key);
    }
}
