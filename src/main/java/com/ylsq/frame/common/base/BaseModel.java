package com.ylsq.frame.common.base;

import java.util.Date;

public interface BaseModel {
	public static int recStatus_valid = 1;
	public static int recStatus_invalid = 0;
	
    public Long getId();
    
    public void setId(Long id);

    public Date getCreateTime();
    
    public void setCreateTime(Date date);
    
    public String getCreateUser();
    
    public void setCreateUser(String user);

    public Integer getRecStatus();
    
    public void setRecStatus(Integer status);

}
