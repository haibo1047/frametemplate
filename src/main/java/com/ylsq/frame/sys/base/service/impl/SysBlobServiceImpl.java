package com.ylsq.frame.sys.base.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ylsq.frame.common.annotation.BaseService;
import com.ylsq.frame.common.base.BaseServiceImpl;
import com.ylsq.frame.sys.base.dao.mapper.SysBlobMapper;
import com.ylsq.frame.sys.base.dao.model.SysBlob;
import com.ylsq.frame.sys.base.dao.model.SysBlobExample;
import com.ylsq.frame.sys.base.service.SysBlobService;

/**
* SysBlobService实现
* Created by harper
*/
@Service
@Transactional
@BaseService
public class SysBlobServiceImpl extends BaseServiceImpl<SysBlobMapper, SysBlob, SysBlobExample> implements SysBlobService {

    private static final Logger log = LoggerFactory.getLogger(SysBlobServiceImpl.class);

    @Autowired
    SysBlobMapper sysBlobMapper;

	@Override
	public Long insert(byte[] bytes, Long businessId) {
		// TODO Auto-generated method stub
		SysBlob sb = new SysBlob();
		sb.setData(bytes);
		sb.setBusinessId(businessId);
		int cnt = sysBlobMapper.insert(sb);
		log.debug("blob: " + cnt);
		return sb.getBlobId();
	}

	@Override
	public byte[] getData(Long businessId) {
		// TODO Auto-generated method stub
		SysBlobExample example = new SysBlobExample();
		example.createCriteria().andBusinessIdEqualTo(businessId);
		List<SysBlob> list = selectByExampleWithBLOBs(example);
		if(list.size() > 0) {
			return list.get(0).getData();
		}
		return null;
	}

}