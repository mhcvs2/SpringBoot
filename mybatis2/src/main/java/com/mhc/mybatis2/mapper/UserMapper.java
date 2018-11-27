package com.mhc.mybatis2.mapper;

import com.mhc.mybatis2.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}