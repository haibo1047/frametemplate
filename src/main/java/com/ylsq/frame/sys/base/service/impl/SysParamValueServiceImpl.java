package com.ylsq.frame.sys.base.service.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ylsq.frame.common.annotation.BaseService;
import com.ylsq.frame.common.base.BaseServiceImpl;
import com.ylsq.frame.sys.base.dao.mapper.SysParamValueMapper;
import com.ylsq.frame.sys.base.dao.model.SysParamValue;
import com.ylsq.frame.sys.base.dao.model.SysParamValueExample;
import com.ylsq.frame.sys.base.service.SysParamValueService;

/**
* SysParamValueService实现
* Created by harper
*/
@Service
@Transactional
@BaseService
public class SysParamValueServiceImpl extends BaseServiceImpl<SysParamValueMapper, SysParamValue, SysParamValueExample> implements SysParamValueService {

    private static final Logger log = LoggerFactory.getLogger(SysParamValueServiceImpl.class);

    @Autowired
    SysParamValueMapper sysParamValueMapper;
    
    @Override
	public List<SysParamValue> selectByParamName(String paramName) {
		// TODO Auto-generated method stub
		SysParamValueExample example = new SysParamValueExample();
		example.createCriteria().andParamNameEqualTo(paramName);
		return selectByExample(example);
	}

	@Override
	public String getValue(SysParamValue value, int valueIndex) {
		// TODO Auto-generated method stub
		try {
			Method mtd = SysParamValue.class.getMethod("getValue"+valueIndex , null);
			String currValue = mtd.invoke(value, null).toString();
			return currValue;
		}catch(Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean setValue(SysParamValue paramValue, int valueIndex, String value) {
		// TODO Auto-generated method stub
		try {
			Method mtd = SysParamValue.class.getMethod("setValue"+valueIndex , String.class);
			mtd.invoke(paramValue, value);
		}catch(Exception e) {
			log.error(e.getMessage());
			return false;
		}
		return true;
	}
}