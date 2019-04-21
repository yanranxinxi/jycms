package com.cms.jycms.service;

import com.cms.jycms.dao.UserInfoMapper;
import com.cms.jycms.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper mapper;

    public int insert(UserInfo model) {
        return mapper.insert(model);
    }

    public int delete(List<String> ids) {
        return mapper.delete(ids);
    }

    public int update(UserInfo model) {
        return mapper.update(model);
    }

    public List<UserInfo> select(Map<String, Object> query) {
        return mapper.select(query);
    }

    public int selectCount(Map<String, Object> query) {
        return mapper.selectCount(query);
    }

    public int selectCountById(int id) {
        return mapper.selectCountById(id);
    }

    public int selectcountByUserName(String userName) {
        return mapper.selectcountByUserName(userName);
    }

    public UserInfo selectById(int id) {
        return mapper.selectById(id);
    }

    public UserInfo selectByUserName(String userName) {
        return mapper.selectByUserName(userName);
    }
}
