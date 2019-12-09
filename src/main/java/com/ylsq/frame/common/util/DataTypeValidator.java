package com.ylsq.frame.common.util;

import org.apache.commons.lang3.StringUtils;

import com.ylsq.frame.common.base.ValidateResult;

public class DataTypeValidator {

	public ValidateResult validate(String field, String value,String dataType, Integer dataLength, Integer notNull) {
		if(StringUtils.isBlank(value)) {
			if(new Integer(1).equals(notNull))
				return new ValidateResult(field + "不能为空");
			return new ValidateResult();
		}
		if(dataLength < value.trim().length())
			return new ValidateResult(String.format("%s超出定义的长度(%s)",field,dataLength));
		if("Integer".equals(dataType) && !StringUtils.isNumeric(value)) {
			return new ValidateResult(String.format("%s定义为数值型，请检查",field));
		}
		return new ValidateResult();
	}
}
