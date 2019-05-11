package com.mhc.mybatis2.service;

import com.mhc.mybatis2.mapper.UserMapper;
import com.mhc.mybatis2.model.User;
import com.mhc.mybatis2.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    OtherService otherService;

    public int addUser(User user){
        System.out.println("addUser============");
        System.out.println(user.toString());
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

    public User getUser(Integer id){
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(id);
        return userMapper.selectByExample(example).get(0);
    }

    public User getByName(String name){
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(name);
        return userMapper.selectByExample(example).get(0);
    }

    public User getUser2(Integer id){
        return otherService.getUser(id);
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
