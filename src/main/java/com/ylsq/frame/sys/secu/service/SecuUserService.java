package com.ylsq.frame.sys.secu.service;

import java.util.List;

import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.sys.secu.dao.model.SecuUser;
import com.ylsq.frame.sys.secu.dao.model.SecuUserExample;

/**
* SecuUserService接口
* Created by shuzheng on 2018/7/26.
*/
public interface SecuUserService extends BaseService<SecuUser, SecuUserExample> {

	/**
	 * 根据用户名查询用户对象
	 * @param username
	 * @return
	 */
	public SecuUser selectByUsername(String username);
	
	/**
	 * 根据机构id查询用户
	 * @param orgId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<SecuUser> selectByOrgId(long orgId, int pageNum, int pageSize);
	
	/**
	 * 查询机构下的用户数
	 * @param orgId
	 * @return
	 */
	public int countbyOrgId(long orgId);
}