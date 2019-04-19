package com.cms.jycms.dao;

import com.cms.jycms.domain.SystemConfig;

public interface SystemConfigMapper {
    int insert(SystemConfig model);
    int delete(String key);
    int update(SystemConfig model);
    SystemConfig select(String key);
}
