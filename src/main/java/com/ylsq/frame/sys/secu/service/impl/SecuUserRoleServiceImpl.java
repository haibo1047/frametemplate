package com.ylsq.frame.sys.secu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ylsq.frame.common.annotation.BaseService;
import com.ylsq.frame.common.base.BaseServiceImpl;
import com.ylsq.frame.sys.secu.dao.mapper.SecuUserRoleMapper;
import com.ylsq.frame.sys.secu.dao.model.SecuUserRole;
import com.ylsq.frame.sys.secu.dao.model.SecuUserRoleExample;
import com.ylsq.frame.sys.secu.service.SecuUserRoleService;

/**
* SecuUserRoleService实现
* Created by harper
*/
@Service
@Transactional
@BaseService
public class SecuUserRoleServiceImpl extends BaseServiceImpl<SecuUserRoleMapper, SecuUserRole, SecuUserRoleExample> implements SecuUserRoleService {

    private static final Logger log = LoggerFactory.getLogger(SecuUserRoleServiceImpl.class);

    @Autowired
    SecuUserRoleMapper secuUserRoleMapper;

	@Override
	public List<SecuUserRole> selectByRoleName(String roleName) {
		// TODO Auto-generated method stub
		SecuUserRoleExample example = new SecuUserRoleExample();
		example.createCriteria().andRoleNameEqualTo(roleName);
		return selectByExample(example);
	}

	@Override
	public List<SecuUserRole> selectByUserName(String userName) {
		// TODO Auto-generated method stub
		SecuUserRoleExample example = new SecuUserRoleExample();
		example.createCriteria().andUserNameEqualTo(userName);
		return selectByExample(example);
	}

}