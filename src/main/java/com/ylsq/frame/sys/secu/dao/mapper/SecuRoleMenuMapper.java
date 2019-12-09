package com.ylsq.frame.sys.secu.dao.mapper;

import com.ylsq.frame.sys.secu.dao.model.SecuRoleMenu;
import com.ylsq.frame.sys.secu.dao.model.SecuRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecuRoleMenuMapper {
    long countByExample(SecuRoleMenuExample example);

    int deleteByExample(SecuRoleMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SecuRoleMenu record);

    int insertSelective(SecuRoleMenu record);

    List<SecuRoleMenu> selectByExample(SecuRoleMenuExample example);

    SecuRoleMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SecuRoleMenu record, @Param("example") SecuRoleMenuExample example);

    int updateByExample(@Param("record") SecuRoleMenu record, @Param("example") SecuRoleMenuExample example);

    int updateByPrimaryKeySelective(SecuRoleMenu record);

    int updateByPrimaryKey(SecuRoleMenu record);
}