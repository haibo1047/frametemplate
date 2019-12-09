package com.ylsq.frame.sys.secu.service;

import java.util.List;

import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.sys.secu.dao.model.SecuUserRole;
import com.ylsq.frame.sys.secu.dao.model.SecuUserRoleExample;

/**
* SecuUserRoleService接口
* Created by harper
*/
public interface SecuUserRoleService extends BaseService<SecuUserRole, SecuUserRoleExample> {

	/**
	 * 根据角色名查询用户角色关联关系表
	 * @param roleName
	 * @return
	 */
	public List<SecuUserRole> selectByRoleName(String roleName);
	
	/**
	 * 根据用户查关联关系表
	 * @param userName
	 * @return
	 */
	public List<SecuUserRole> selectByUserName(String userName);
}