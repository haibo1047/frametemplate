package com.ylsq.frame.sys.secu.service;

import java.util.List;

import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.sys.secu.dao.model.SecuMenu;
import com.ylsq.frame.sys.secu.dao.model.SecuMenuExample;

/**
* SecuMenuService接口
* Created by harper
*/
public interface SecuMenuService extends BaseService<SecuMenu, SecuMenuExample> {

	/**
	 * 根据登录名查询菜单列表
	 * @param userName
	 * @return
	 */
	public List<SecuMenu> selectByUserName(String userName);
	
	/**
	 * 根据菜单名查询
	 * @param menuName
	 * @return
	 */
	public SecuMenu selectByMenuName(String menuName);
}