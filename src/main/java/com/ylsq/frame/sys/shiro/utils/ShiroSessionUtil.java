package com.ylsq.frame.sys.shiro.utils;

import org.apache.shiro.SecurityUtils;

public class ShiroSessionUtil {

	public static boolean replace(String key, Object value) {
		Object original = SecurityUtils.getSubject().getSession().getAttribute(key);
		if(original != null && original.equals(value) ) {
			return false;
		}
		SecurityUtils.getSubject().getSession().setAttribute(key, value);
		return true;
	}
}
