package com.ylsq.frame.sys.secu.dao.mapper;

import com.ylsq.frame.sys.secu.dao.model.SecuRole;
import com.ylsq.frame.sys.secu.dao.model.SecuRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecuRoleMapper {
    long countByExample(SecuRoleExample example);

    int deleteByExample(SecuRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SecuRole record);

    int insertSelective(SecuRole record);

    List<SecuRole> selectByExample(SecuRoleExample example);

    SecuRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SecuRole record, @Param("example") SecuRoleExample example);

    int updateByExample(@Param("record") SecuRole record, @Param("example") SecuRoleExample example);

    int updateByPrimaryKeySelective(SecuRole record);

    int updateByPrimaryKey(SecuRole record);
}