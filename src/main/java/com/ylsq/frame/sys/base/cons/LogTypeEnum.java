package com.ylsq.frame.sys.base.cons;

public enum LogTypeEnum {
	Login("login"),
	Logout("logout"),
	Menu_Click("menu_click"),
	Approve("approved"),
	Reject("rejected")
	;
	
	final private String v;
	
	LogTypeEnum(String tv) {
		v = tv;
	}

	public String getV() {
		return v;
	}
}
