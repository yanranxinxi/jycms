package com.cms.jycms.dao;

import com.cms.jycms.domain.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    int insert(UserInfo model);
    int delete(List<String> ids);
    int update(UserInfo model);
    List<UserInfo> select(Map<String, Object> query);
    int selectCount(Map<String, Object> query);
    int selectCountById(int id);
    int selectcountByUserName(String userName);
    UserInfo selectById(int id);

    UserInfo selectByUserName(String userName);
}