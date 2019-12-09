package com.ylsq.frame.sys.base.service;

import java.util.Date;

import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.sys.base.dao.model.SysLog;
import com.ylsq.frame.sys.base.dao.model.SysLogExample;

/**
* SysLogService接口
* Created by harper
*/
public interface SysLogService extends BaseService<SysLog, SysLogExample> {

	/**
	 * 记录登录日志
	 * @param login
	 * @param loginTime
	 * @param ip
	 * @param remark
	 * @return
	 */
	public int doLogin(String login,Date loginTime,String ip, String remark);
	
	/**
	 * 记录登出日志
	 * @param login
	 * @param logoutTime 
	 * @param ip
	 * @param remark
	 * @return
	 */
	public int doLogout(String login,Date logoutTime,String ip,String remark);
	
	/**
	 * 记录菜单日志
	 * @param login
	 * @param clickTime
	 * @param ip
	 * @param menu
	 * @return
	 */
	public int doMenuClick(String login,Date clickTime, String ip,String menu);
	
	/**
	 * 记录审批日志
	 * @param login
	 * @param time
	 * @param approveType
	 * @param requestId
	 * @return
	 */
	public int doApprove(String login, Date time, String approveType, Long requestId);
	
	/**
	 * 记录驳回日志
	 * @param login
	 * @param time
	 * @param approveType
	 * @param requestId
	 * @return
	 */
	public int doReject(String login, Date time, String approveType, Long requestId);
}