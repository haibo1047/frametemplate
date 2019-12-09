package com.ylsq.frame.common.util;

import java.security.MessageDigest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ylsq.frame.common.base.SystemConstants;

public class PasswordUtils {
	private static Logger log = LoggerFactory.getLogger(PasswordUtils.class);
	
	public static String encode(String raw, String salt) {
		String result = "";
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(StringUtils.defaultIfBlank(salt, SystemConstants.Salt_System_User_Pwd).getBytes("UTF8"));
			m.update(raw.getBytes("UTF8"));
			byte s[] = m.digest();
			for (int i = 0; i < s.length; i++) {
				result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);
			}
		}catch(Exception e) {
			log.error("密码加密失败：" + e.getMessage());
		}
		return result.length()==0 ? null : result;
	}
	
	public static String encode(String raw){
		return encode(raw, SystemConstants.Salt_System_User_Pwd);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(encode("nuo1"));
		}catch(Exception e) {
			
		}
	}

}
