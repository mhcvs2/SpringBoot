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

    public int addUser2(User user) {
        User u = new User();
        u.setPassword(user.getPassword());
        u.setPhone(user.getPhone());
        u.setUserName(user.getUserName());
        userMapper.insertSelective(u);
        System.out.println(u.getPassword());
        return u.getUserId();
    }


}
