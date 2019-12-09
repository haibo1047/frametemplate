package com.ylsq.frame.sys.base.dao.mapper;

import com.ylsq.frame.sys.base.dao.model.SysProfile;
import com.ylsq.frame.sys.base.dao.model.SysProfileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysProfileMapper {
    long countByExample(SysProfileExample example);

    int deleteByExample(SysProfileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysProfile record);

    int insertSelective(SysProfile record);

    List<SysProfile> selectByExample(SysProfileExample example);

    SysProfile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysProfile record, @Param("example") SysProfileExample example);

    int updateByExample(@Param("record") SysProfile record, @Param("example") SysProfileExample example);

    int updateByPrimaryKeySelective(SysProfile record);

    int updateByPrimaryKey(SysProfile record);
}