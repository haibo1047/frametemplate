package com.ylsq.frame.sys.secu.dao.mapper;

import com.ylsq.frame.sys.secu.dao.model.SecuOrg;
import com.ylsq.frame.sys.secu.dao.model.SecuOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecuOrgMapper {
    long countByExample(SecuOrgExample example);

    int deleteByExample(SecuOrgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SecuOrg record);

    int insertSelective(SecuOrg record);

    List<SecuOrg> selectByExample(SecuOrgExample example);

    SecuOrg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SecuOrg record, @Param("example") SecuOrgExample example);

    int updateByExample(@Param("record") SecuOrg record, @Param("example") SecuOrgExample example);

    int updateByPrimaryKeySelective(SecuOrg record);

    int updateByPrimaryKey(SecuOrg record);
}