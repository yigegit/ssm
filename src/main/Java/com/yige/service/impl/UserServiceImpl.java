package com.yige.service.impl;

import com.yige.mapper.UserMapper;
import com.yige.pojo.User;
import com.yige.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(User user) {
        List<User> users =userMapper.queryByNamePwd(user);
        if (users!=null &&users.size()==1){
            return users.get(0);
        }else {
            return null;
        }



    }
}
