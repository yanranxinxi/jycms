package com.cms.jycms.dao;

import com.cms.jycms.domain.LeaveMessage;

import java.util.List;
import java.util.Map;

public interface LeaveMessageMapper {
    int insert(LeaveMessage model);

    int delete(List<String> ids);

    List<LeaveMessage> selectAll(Map<String, Object> query);

    int selectCount(Map<String, Object> query);
}
