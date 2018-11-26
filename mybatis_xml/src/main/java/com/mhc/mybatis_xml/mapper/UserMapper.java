package com.mhc.mybatis_xml.mapper;

import com.mhc.mybatis_xml.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    User insert(User user);

}
