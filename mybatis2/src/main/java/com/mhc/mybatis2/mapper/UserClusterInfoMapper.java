package com.mhc.mybatis2.mapper;

import com.mhc.mybatis2.model.UserClusterInfo;
import com.mhc.mybatis2.model.UserClusterInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserClusterInfoMapper {
    int countByExample(UserClusterInfoExample example);

    int deleteByExample(UserClusterInfoExample example);

    int insert(UserClusterInfo record);

    int insertSelective(UserClusterInfo record);

    List<UserClusterInfo> selectByExample(UserClusterInfoExample example);

    int updateByExampleSelective(@Param("record") UserClusterInfo record, @Param("example") UserClusterInfoExample example);

    int updateByExample(@Param("record") UserClusterInfo record, @Param("example") UserClusterInfoExample example);
}