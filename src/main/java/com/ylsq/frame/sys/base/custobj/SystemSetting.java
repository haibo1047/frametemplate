package com.ylsq.frame.sys.base.custobj;

public class SystemSetting {
	private Integer valueIndex;
	private String config;
	private String dataType;
	private Integer dataLength;
	private Integer notNull;
	private String name;
	private String value;
	
	public static String Config_Db_backup_path = "db_backup_path";
	
	public Integer getValueIndex() {
		return valueIndex;
	}
	public void setValueIndex(Integer valueIndex) {
		this.valueIndex = valueIndex;
	}
	public String getConfig() {
		return config;
	}
	public void setConfig(String config) {
		this.config = config;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public Integer getDataLength() {
		return dataLength;
	}
	public void setDataLength(Integer dataLength) {
		this.dataLength = dataLength;
	}
	public Integer getNotNull() {
		return notNull;
	}
	public void setNotNull(Integer notNull) {
		this.notNull = notNull;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[valueIndex:%s, config:%s, name:%s, value:%s, dataType: %s, dataLength: %s]"
				, getValueIndex(), getConfig(), getName(), getValue(),getDataType(), getDataLength());
	}
}
