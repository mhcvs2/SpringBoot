package com.mhc.mybatis.service.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mhc.mybatis.mapper.UserMapper;
import com.mhc.mybatis.model.User;
import com.mhc.mybatis.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Transactional
    public int addUser2(User user) {
        userMapper.insert(user.getUserName(), user.getPassword(), user.getPhone());
        if(!user.getUserName().equals("")){
            throw new IllegalArgumentException("dfsdf");
        }
        return 1;
    }

    @Override
    @Transactional
    public int addUser(User user) {
        userMapper.insert(user.getUserName(), user.getPassword(), user.getPhone());
        if(!user.getUserName().equals("")){
            throw new IllegalArgumentException("dfsdf");
        }
        return 1;
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectUsers();
        return new PageInfo<User>(users);
    }
    
}
