package com.mhc.mybatis.service.user;

import com.github.pagehelper.PageInfo;
import com.mhc.mybatis.model.User;

public interface UserService {

    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);

}
