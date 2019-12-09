package com.ylsq.frame.sys.base.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ylsq.frame.common.annotation.BaseService;
import com.ylsq.frame.common.base.BaseServiceImpl;
import com.ylsq.frame.sys.base.dao.mapper.SysParamConfigMapper;
import com.ylsq.frame.sys.base.dao.model.SysParamConfig;
import com.ylsq.frame.sys.base.dao.model.SysParamConfigExample;
import com.ylsq.frame.sys.base.service.SysParamConfigService;

/**
* SysParamConfigService实现
* Created by harper
*/
@Service
@Transactional
@BaseService
public class SysParamConfigServiceImpl extends BaseServiceImpl<SysParamConfigMapper, SysParamConfig, SysParamConfigExample> implements SysParamConfigService {

    private static final Logger log = LoggerFactory.getLogger(SysParamConfigServiceImpl.class);

    @Autowired
    SysParamConfigMapper sysParamConfigMapper;

	@Override
	public List<SysParamConfig> selectByParamName(String paramName) {
		SysParamConfigExample example = new SysParamConfigExample();
		example.createCriteria().andParamNameEqualTo(paramName);
		example.setOrderByClause(" config_order");
		return selectByExample(example);
	}

}