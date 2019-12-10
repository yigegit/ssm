package com.yige.mapper;

import com.yige.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> queryByNamePwd(User user);
}
