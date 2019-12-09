package com.ylsq.frame.sys.secu.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ylsq.frame.common.annotation.BaseService;
import com.ylsq.frame.common.base.BaseServiceImpl;
import com.ylsq.frame.sys.secu.dao.mapper.SecuMenuMapper;
import com.ylsq.frame.sys.secu.dao.model.SecuMenu;
import com.ylsq.frame.sys.secu.dao.model.SecuMenuExample;
import com.ylsq.frame.sys.secu.service.SecuMenuService;

/**
* SecuMenuService实现
* Created by harper
*/
@Service
@Transactional
@BaseService
public class SecuMenuServiceImpl extends BaseServiceImpl<SecuMenuMapper, SecuMenu, SecuMenuExample> implements SecuMenuService {

    private static final Logger log = LoggerFactory.getLogger(SecuMenuServiceImpl.class);

    @Autowired
    SecuMenuMapper secuMenuMapper;

	@Override
	public List<SecuMenu> selectByUserName(String userName) {
		// TODO Auto-generated method stub
		List<SecuMenu> userMenus = secuMenuMapper.selectByUserName(userName);
		
		return userMenus;
	}

	@Override
	public SecuMenu selectByMenuName(String menuName) {
		// TODO Auto-generated method stub
		SecuMenuExample example = new SecuMenuExample();
		example.createCriteria().andMenuNameEqualTo(menuName);
		List<SecuMenu> list = selectByExample(example);
		if(list.size()>0)
			return list.get(0);
		return null;
	}

}