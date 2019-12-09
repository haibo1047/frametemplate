package com.ylsq.frame.sys.base.dao.mapper;

import com.ylsq.frame.sys.base.dao.model.SysParamValue;
import com.ylsq.frame.sys.base.dao.model.SysParamValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysParamValueMapper {
    long countByExample(SysParamValueExample example);

    int deleteByExample(SysParamValueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysParamValue record);

    int insertSelective(SysParamValue record);

    List<SysParamValue> selectByExample(SysParamValueExample example);

    SysParamValue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysParamValue record, @Param("example") SysParamValueExample example);

    int updateByExample(@Param("record") SysParamValue record, @Param("example") SysParamValueExample example);

    int updateByPrimaryKeySelective(SysParamValue record);

    int updateByPrimaryKey(SysParamValue record);
}