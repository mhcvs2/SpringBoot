package com.mhc.mybatis2.service;

import com.mhc.mybatis2.mapper.UserMapper;
import com.mhc.mybatis2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public int addUser(User user){
        return userMapper.insert(user);
    }

}
