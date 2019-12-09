package com.ylsq.frame.sys.secu.service;

import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.sys.secu.dao.model.SecuRole;
import com.ylsq.frame.sys.secu.dao.model.SecuRoleExample;

/**
* SecuRoleService接口
* Created by shuzheng on 2018/8/5.
*/
public interface SecuRoleService extends BaseService<SecuRole, SecuRoleExample> {

	/**
	 * 根据roleName查询角色
	 * @param roleName
	 * @return
	 */
	public SecuRole selectByRoleName(String roleName);
}