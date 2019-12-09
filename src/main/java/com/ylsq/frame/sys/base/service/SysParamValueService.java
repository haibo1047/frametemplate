package com.ylsq.frame.sys.base.service;

import java.util.List;

import com.ylsq.frame.common.base.BaseService;
import com.ylsq.frame.sys.base.dao.model.SysParamValue;
import com.ylsq.frame.sys.base.dao.model.SysParamValueExample;

/**
* SysParamValueService接口
* Created by harper
*/
public interface SysParamValueService extends BaseService<SysParamValue, SysParamValueExample> {

	/**
	 * 根据参数名查询参数值列表
	 * @param paramName
	 * @return
	 */
	public List<SysParamValue> selectByParamName(String paramName);
	
	/**
	 * 根据值索引查询值
	 * @param value
	 * @param valueIndex
	 * @return
	 */
	public String getValue(SysParamValue paramValue, int valueIndex);
	
	/**
	 * 根据索引设置参数值
	 * @param paramValue
	 * @param valueIndex
	 * @param value
	 * @return
	 */
	public boolean setValue(SysParamValue paramValue, int valueIndex, String value);
}