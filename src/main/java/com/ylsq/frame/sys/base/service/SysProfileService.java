package com.ylsq.frame.sys.base.service;

import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.sys.base.dao.model.SysProfile;
import com.ylsq.frame.sys.base.dao.model.SysProfileExample;

/**
* SysProfileService接口
* Created by harper
*/
public interface SysProfileService extends BaseService<SysProfile, SysProfileExample> {

	/**
	 * 根据登录名查询配置
	 * @param login
	 * @return
	 */
	public SysProfile selectByLogin(String login);
	
	/**
	 * 创建一个默认配置
	 * @return
	 */
	public SysProfile buildDefault(String login);
}