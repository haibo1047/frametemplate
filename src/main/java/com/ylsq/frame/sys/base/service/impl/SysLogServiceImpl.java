package com.ylsq.frame.sys.base.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ylsq.frame.common.annotation.BaseService;
import com.ylsq.frame.common.base.BaseServiceImpl;
import com.ylsq.frame.sys.base.cons.LogTypeEnum;
import com.ylsq.frame.sys.base.dao.mapper.SysLogMapper;
import com.ylsq.frame.sys.base.dao.model.SysLog;
import com.ylsq.frame.sys.base.dao.model.SysLogExample;
import com.ylsq.frame.sys.base.service.SysLogService;

/**
* SysLogService实现
* Created by harper
*/
@Service
@Transactional
@BaseService
public class SysLogServiceImpl extends BaseServiceImpl<SysLogMapper, SysLog, SysLogExample> implements SysLogService {

    private static final Logger log = LoggerFactory.getLogger(SysLogServiceImpl.class);

    @Autowired
    SysLogMapper sysLogMapper;

	@Override
	public int doLogin(String login, Date loginTime, String ip, String remark) {
		// TODO Auto-generated method stub
		SysLog sl = new SysLog();
		sl.setLogin(login);
		sl.setOperateTime(loginTime);
		sl.setOperateIp(ip);
		sl.setLogContent(remark);
		sl.setLogType(LogTypeEnum.Login.getV());
		return sysLogMapper.insert(sl);
	}

	@Override
	public int doLogout(String login, Date logoutTime, String ip, String remark) {
		// TODO Auto-generated method stub
		SysLog sl = new SysLog();
		sl.setLogin(login);
		sl.setOperateTime(logoutTime);
		sl.setOperateIp(ip);
		sl.setLogContent(remark);
		sl.setLogType(LogTypeEnum.Logout.getV());
		return sysLogMapper.insert(sl);
	}

	@Override
	public int doMenuClick(String login, Date clickTime, String ip, String menu) {
		// TODO Auto-generated method stub
		SysLog sl = new SysLog();
		sl.setLogin(login);
		sl.setOperateTime(clickTime);
		sl.setOperateIp(ip);
		sl.setLogContent(menu);
		sl.setLogType(LogTypeEnum.Menu_Click.getV());
		return sysLogMapper.insert(sl);
	}

	@Override
	public int doApprove(String login, Date time, String approveType, Long requestId) {
		// TODO Auto-generated method stub
		SysLog sl = new SysLog();
		sl.setLogin(login);
		sl.setOperateTime(time);
		sl.setLogType(LogTypeEnum.Approve.getV());
		sl.setLogContent("[type]"+approveType +";[id]" + requestId);
		return sysLogMapper.insert(sl);
	}

	@Override
	public int doReject(String login, Date time, String approveType, Long requestId) {
		// TODO Auto-generated method stub
		SysLog sl = new SysLog();
		sl.setLogin(login);
		sl.setOperateTime(time);
		sl.setLogType(LogTypeEnum.Reject.getV());
		sl.setLogContent("[type]"+approveType +";[id]" + requestId);
		return sysLogMapper.insert(sl);
	}

	
}