package com.mhc.mybatis2.mapper;

import com.mhc.mybatis2.model.InstanceResourceGroupStatus;
import com.mhc.mybatis2.model.InstanceResourceGroupStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InstanceResourceGroupStatusMapper {
    int countByExample(InstanceResourceGroupStatusExample example);

    int deleteByExample(InstanceResourceGroupStatusExample example);

    int insert(InstanceResourceGroupStatus record);

    int insertSelective(InstanceResourceGroupStatus record);

    List<InstanceResourceGroupStatus> selectByExample(InstanceResourceGroupStatusExample example);

    int updateByExampleSelective(@Param("record") InstanceResourceGroupStatus record, @Param("example") InstanceResourceGroupStatusExample example);

    int updateByExample(@Param("record") InstanceResourceGroupStatus record, @Param("example") InstanceResourceGroupStatusExample example);
}