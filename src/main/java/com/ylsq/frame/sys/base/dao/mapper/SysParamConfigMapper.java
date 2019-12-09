package com.ylsq.frame.sys.base.dao.mapper;

import com.ylsq.frame.sys.base.dao.model.SysParamConfig;
import com.ylsq.frame.sys.base.dao.model.SysParamConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysParamConfigMapper {
    long countByExample(SysParamConfigExample example);

    int deleteByExample(SysParamConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysParamConfig record);

    int insertSelective(SysParamConfig record);

    List<SysParamConfig> selectByExample(SysParamConfigExample example);

    SysParamConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysParamConfig record, @Param("example") SysParamConfigExample example);

    int updateByExample(@Param("record") SysParamConfig record, @Param("example") SysParamConfigExample example);

    int updateByPrimaryKeySelective(SysParamConfig record);

    int updateByPrimaryKey(SysParamConfig record);
}