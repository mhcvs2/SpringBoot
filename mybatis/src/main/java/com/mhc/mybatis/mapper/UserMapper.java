package com.mhc.mybatis.mapper;

import com.mhc.mybatis.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE phone = #{phone}")
    User findUserByPhone(@Param("phone") String phone);

    @Select("SELECT * FROM t_user")
    List<User> selectUsers();

    @Insert("INSERT INTO t_user(userName, password, phone) VALUES(#{name}, #{password}, #{phone})")
    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);

}
