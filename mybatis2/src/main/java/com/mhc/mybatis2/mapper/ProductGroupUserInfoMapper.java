package com.mhc.mybatis2.mapper;

import com.mhc.mybatis2.model.ProductGroupUserInfo;
import com.mhc.mybatis2.model.ProductGroupUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductGroupUserInfoMapper {
    int countByExample(ProductGroupUserInfoExample example);

    int deleteByExample(ProductGroupUserInfoExample example);

    int insert(ProductGroupUserInfo record);

    int insertSelective(ProductGroupUserInfo record);

    List<ProductGroupUserInfo> selectByExample(ProductGroupUserInfoExample example);

    int updateByExampleSelective(@Param("record") ProductGroupUserInfo record, @Param("example") ProductGroupUserInfoExample example);

    int updateByExample(@Param("record") ProductGroupUserInfo record, @Param("example") ProductGroupUserInfoExample example);
}