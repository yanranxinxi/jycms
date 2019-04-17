package com.cms.jycms.service;

import com.cms.jycms.dao.UserInfoMapper;
import com.cms.jycms.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper mapper;

    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public int insert(UserInfo record) {
        return mapper.insert(record);
    }

    public int insertSelective(UserInfo record) {
        return mapper.insertSelective(record);
    }

    public UserInfo selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(UserInfo record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserInfo record) {
        return mapper.updateByPrimaryKey(record);
    }
}
