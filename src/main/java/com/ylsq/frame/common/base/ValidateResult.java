package com.ylsq.frame.common.base;

import java.io.Serializable;

public class ValidateResult implements Serializable {
	private static final long serialVersionUID = -9049202168701287451L;
	
	public static ValidateResult Passed = new ValidateResult();
	public static ValidateResult Failed = new ValidateResult(false, "验证失败");
	
	public ValidateResult() {
		this.passed = true;
	}
	public ValidateResult(String msg) {
		this.passed = false;
		this.msg = msg;
	}
	public ValidateResult(boolean passed, String msg) {
		this.passed = passed;
		this.msg = msg;
	}


	private boolean passed;
	private String msg;
	
	
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + isPassed() + "- "+ getMsg() + "]";
	}
}
