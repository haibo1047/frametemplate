package com.ylsq.frame.common.base;

public enum SysParamEnum {
	Rec_Status("record_status"),
	Menu_Module("menu_module"),
	Param_Data_type("param_data_type"),
	Alternative("alternative"),
	Terminal_Status("terminal_status"),
	Application_Type("application_type"),
	Sys_Log_Type("system_log_type"),
	System_Config("system_config"),
	Strategy_Type("strategy_type"),
	Strategy_outgoing_level("outgoing_level"),
	Request_Approve_Status("approve_status")
	;
	
	private final String constant;

	SysParamEnum(String c) {
		this.constant = c;
	}

	public String getConstant() {
		return constant;
	}
}
