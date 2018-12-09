package com.mhc.mybatis_xml.service;

import com.mhc.mybatis_xml.mapper.UserMapper;
import com.mhc.mybatis_xml.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public int addUser(User user){
        return userMapper.insert(user).getId();
    }

}
