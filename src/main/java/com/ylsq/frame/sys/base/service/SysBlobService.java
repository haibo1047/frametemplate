package com.ylsq.frame.sys.base.service;

import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.sys.base.dao.model.SysBlob;
import com.ylsq.frame.sys.base.dao.model.SysBlobExample;

/**
* SysBlobService接口
* Created by harper
*/
public interface SysBlobService extends BaseService<SysBlob, SysBlobExample> {

	/**
	 * 保存数据
	 * @param bytes
	 * @return
	 */
	public Long insert(byte[] bytes, Long businessId);
	
	/**
	 * 根据业务ID获取数据
	 * @param businessId
	 * @return
	 */
	public byte[] getData(Long businessId);
}