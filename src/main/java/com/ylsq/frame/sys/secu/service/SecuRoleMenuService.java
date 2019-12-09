package com.ylsq.frame.sys.secu.service;

import java.util.List;

import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.sys.secu.dao.model.SecuRoleMenu;
import com.ylsq.frame.sys.secu.dao.model.SecuRoleMenuExample;

/**
* SecuRoleMenuService接口
* Created by harper
*/
public interface SecuRoleMenuService extends BaseService<SecuRoleMenu, SecuRoleMenuExample> {

	/**
	 * 根据角色名查找角色菜单关联关系表
	 * @param roleName
	 * @return
	 */
	public List<SecuRoleMenu> selectByRoleName(String roleName);
	
	/**
	 * 根据菜单查询角色菜单关联关系
	 * @param menuName
	 * @return
	 */
	public List<SecuRoleMenu> selectByMenuName(String menuName);
}