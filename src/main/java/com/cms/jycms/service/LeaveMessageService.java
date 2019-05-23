package com.cms.jycms.service;

import com.cms.jycms.dao.LeaveMessageMapper;
import com.cms.jycms.domain.LeaveMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LeaveMessageService {
    @Autowired
    private LeaveMessageMapper mapper;

    public int insert(LeaveMessage model) {
        return mapper.insert(model);
    }

    public int delete(List<String> ids) {
        return mapper.delete(ids);
    }


    public List<LeaveMessage> selectAll(Map<String, Object> query) {
        return mapper.selectAll(query);
    }

    public int selectCount(Map<String, Object> query) {
        return mapper.selectCount(query);
    }
}
