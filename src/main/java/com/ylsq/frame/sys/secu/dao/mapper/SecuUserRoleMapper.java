package com.ylsq.frame.sys.secu.dao.mapper;

import com.ylsq.frame.sys.secu.dao.model.SecuUserRole;
import com.ylsq.frame.sys.secu.dao.model.SecuUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecuUserRoleMapper {
    long countByExample(SecuUserRoleExample example);

    int deleteByExample(SecuUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SecuUserRole record);

    int insertSelective(SecuUserRole record);

    List<SecuUserRole> selectByExample(SecuUserRoleExample example);

    SecuUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SecuUserRole record, @Param("example") SecuUserRoleExample example);

    int updateByExample(@Param("record") SecuUserRole record, @Param("example") SecuUserRoleExample example);

    int updateByPrimaryKeySelective(SecuUserRole record);

    int updateByPrimaryKey(SecuUserRole record);
}