package com.ylsq.frame.sys.base.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ylsq.frame.common.annotation.BaseService;
import com.ylsq.frame.common.base.BaseServiceImpl;
import com.ylsq.frame.common.base.SystemConstants;
import com.ylsq.frame.sys.base.dao.mapper.SysProfileMapper;
import com.ylsq.frame.sys.base.dao.model.SysProfile;
import com.ylsq.frame.sys.base.dao.model.SysProfileExample;
import com.ylsq.frame.sys.base.service.SysProfileService;

/**
* SysProfileService实现
* Created by harper
*/
@Service
@Transactional
@BaseService
public class SysProfileServiceImpl extends BaseServiceImpl<SysProfileMapper, SysProfile, SysProfileExample> implements SysProfileService {

    private static final Logger log = LoggerFactory.getLogger(SysProfileServiceImpl.class);

    @Autowired
    SysProfileMapper sysProfileMapper;

	@Override
	public SysProfile selectByLogin(String login) {
		// TODO Auto-generated method stub
		SysProfileExample example = new SysProfileExample();
		example.createCriteria().andLoginEqualTo(login);
		List<SysProfile> list = selectByExample(example);
		if(list.size()>0) {
			return list.get(0);
		}
		log.debug("didn't find profile for this login:" + login);
		return buildDefault(login);
	}

	@Override
	public SysProfile buildDefault(String login) {
		// TODO Auto-generated method stub
		SysProfile profile = new SysProfile();
		profile.setLogin(login);
		profile.setPageSize(SystemConstants.Default_Page_Size);
		return profile;
	}

}