package com.ylsq.frame.sys.base.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ylsq.frame.common.annotation.BaseService;
import com.ylsq.frame.common.base.BaseServiceImpl;
import com.ylsq.frame.sys.base.dao.mapper.SysParamMapper;
import com.ylsq.frame.sys.base.dao.model.SysParam;
import com.ylsq.frame.sys.base.dao.model.SysParamExample;
import com.ylsq.frame.sys.base.service.SysParamService;

/**
* SysParamService实现
* Created by harper
*/
@Service
@Transactional
@BaseService
public class SysParamServiceImpl extends BaseServiceImpl<SysParamMapper, SysParam, SysParamExample> implements SysParamService {

    private static final Logger log = LoggerFactory.getLogger(SysParamServiceImpl.class);

    @Autowired
    SysParamMapper sysParamMapper;

}