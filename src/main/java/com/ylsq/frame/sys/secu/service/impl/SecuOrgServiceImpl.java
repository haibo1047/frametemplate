package com.ylsq.frame.sys.secu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ylsq.frame.common.annotation.BaseService;
import com.ylsq.frame.common.base.BaseServiceImpl;
import com.ylsq.frame.common.base.SystemConstants;
import com.ylsq.frame.sys.secu.custobj.CustOrg;
import com.ylsq.frame.sys.secu.dao.mapper.SecuOrgMapper;
import com.ylsq.frame.sys.secu.dao.model.SecuOrg;
import com.ylsq.frame.sys.secu.dao.model.SecuOrgExample;
import com.ylsq.frame.sys.secu.service.SecuOrgService;

/**
* SecuOrgService实现
* Created by harper
*/
@Service
@Transactional
@BaseService
public class SecuOrgServiceImpl extends BaseServiceImpl<SecuOrgMapper, SecuOrg, SecuOrgExample> implements SecuOrgService {

    private static final Logger log = LoggerFactory.getLogger(SecuOrgServiceImpl.class);

    @Autowired
    SecuOrgMapper secuOrgMapper;

	@Override
	public SecuOrg selectByName(String orgName) {
		// TODO Auto-generated method stub
		SecuOrgExample example = new SecuOrgExample();
		example.createCriteria().andOrgNameEqualTo(orgName);
		List<SecuOrg> list = selectByExample(example);
		if(list.size() >= 1)
			return list.get(0);
		return null;
	}

	@Override
	public List<SecuOrg> selectByParentId(long parentId) {
		// TODO Auto-generated method stub
		SecuOrgExample example = new SecuOrgExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		return selectByExample(example);
	}

	@Override
	public List<CustOrg> buildCustomOrgs(List<SecuOrg> list) {
		// TODO Auto-generated method stub
		List<CustOrg> orgList = new ArrayList<>();
		
		Map<Long,Long> pMap = new HashMap<>();
		Map<Long,CustOrg> orgMap = new HashMap<>();
		
		for(SecuOrg e : list) {
			CustOrg org = new CustOrg(e);
			orgMap.put(e.getId(), org);
			if(SystemConstants.Root_Org_Id == e.getParentId()) {
				orgList.add(org);
			}
			else {
				pMap.put(e.getId(), e.getParentId());
			}
		}
		for(Long id : pMap.keySet()) {
			Long pid = pMap.get(id);
			CustOrg pOrg = orgMap.get(pid);
			List<CustOrg> subs = pOrg.getSubOrgs();
			if(subs == null) {
				subs = new ArrayList<>();
				pOrg.setSubOrgs(subs);
			}
			subs.add(orgMap.get(id));
		}
		log.debug("top organization size: " + orgList.size());
		return orgList;
	}

}