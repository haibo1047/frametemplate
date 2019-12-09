package com.ylsq.frame.sys.secu.service;

import java.util.List;

import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.sys.secu.custobj.CustOrg;
import com.ylsq.frame.sys.secu.dao.model.SecuOrg;
import com.ylsq.frame.sys.secu.dao.model.SecuOrgExample;

/**
* SecuOrgService接口
* Created by harper
*/
public interface SecuOrgService extends BaseService<SecuOrg, SecuOrgExample> {
	/**
	 * 根据机构名称查询
	 * @param orgName
	 * @return
	 */
	public SecuOrg selectByName(String orgName);
	
	/**
	 * 根据父id查询子机构列表
	 * @param parentId
	 * @return
	 */
	public List<SecuOrg> selectByParentId(long parentId);
	
	/**
	 * 重构机构树，可以为jsTree使用
	 * @param list
	 * @return
	 */
	public List<CustOrg> buildCustomOrgs(List<SecuOrg> list);
}