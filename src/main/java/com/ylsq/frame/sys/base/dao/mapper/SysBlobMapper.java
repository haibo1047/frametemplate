package com.ylsq.frame.sys.base.dao.mapper;

import com.ylsq.frame.sys.base.dao.model.SysBlob;
import com.ylsq.frame.sys.base.dao.model.SysBlobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysBlobMapper {
    long countByExample(SysBlobExample example);

    int deleteByExample(SysBlobExample example);

    int deleteByPrimaryKey(Long blobId);

    int insert(SysBlob record);

    int insertSelective(SysBlob record);

    List<SysBlob> selectByExampleWithBLOBs(SysBlobExample example);

    List<SysBlob> selectByExample(SysBlobExample example);

    SysBlob selectByPrimaryKey(Long blobId);

    int updateByExampleSelective(@Param("record") SysBlob record, @Param("example") SysBlobExample example);

    int updateByExampleWithBLOBs(@Param("record") SysBlob record, @Param("example") SysBlobExample example);

    int updateByExample(@Param("record") SysBlob record, @Param("example") SysBlobExample example);

    int updateByPrimaryKeySelective(SysBlob record);

    int updateByPrimaryKeyWithBLOBs(SysBlob record);

    int updateByPrimaryKey(SysBlob record);
}