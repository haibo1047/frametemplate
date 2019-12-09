package com.ylsq.frame.sys.base.dao.model;

import com.ylsq.frame.common.base.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class SysParamConfig implements BaseModel, Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 参数名
     *
     * @mbg.generated
     */
    private String paramName;

    /**
     * 配置名
     *
     * @mbg.generated
     */
    private String configName;

    /**
     * 数据类型
     *
     * @mbg.generated
     */
    private String dataType;

    /**
     * 显示名称
     *
     * @mbg.generated
     */
    private String showName;

    /**
     * 数据类型
     *
     * @mbg.generated
     */
    private Integer dataLength;

    /**
     * 是否为空
     *
     * @mbg.generated
     */
    private Integer notNull;

    /**
     * 是否唯一属性之一
     *
     * @mbg.generated
     */
    private Integer isOfUniq;

    /**
     * 序号
     *
     * @mbg.generated
     */
    private Integer configOrder;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbg.generated
     */
    private String createUser;

    /**
     * 记录状态
     *
     * @mbg.generated
     */
    private Integer recStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
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

    public Integer getIsOfUniq() {
        return isOfUniq;
    }

    public void setIsOfUniq(Integer isOfUniq) {
        this.isOfUniq = isOfUniq;
    }

    public Integer getConfigOrder() {
        return configOrder;
    }

    public void setConfigOrder(Integer configOrder) {
        this.configOrder = configOrder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Integer getRecStatus() {
        return recStatus;
    }

    public void setRecStatus(Integer recStatus) {
        this.recStatus = recStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", paramName=").append(paramName);
        sb.append(", configName=").append(configName);
        sb.append(", dataType=").append(dataType);
        sb.append(", showName=").append(showName);
        sb.append(", dataLength=").append(dataLength);
        sb.append(", notNull=").append(notNull);
        sb.append(", isOfUniq=").append(isOfUniq);
        sb.append(", configOrder=").append(configOrder);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", recStatus=").append(recStatus);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysParamConfig other = (SysParamConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParamName() == null ? other.getParamName() == null : this.getParamName().equals(other.getParamName()))
            && (this.getConfigName() == null ? other.getConfigName() == null : this.getConfigName().equals(other.getConfigName()))
            && (this.getDataType() == null ? other.getDataType() == null : this.getDataType().equals(other.getDataType()))
            && (this.getShowName() == null ? other.getShowName() == null : this.getShowName().equals(other.getShowName()))
            && (this.getDataLength() == null ? other.getDataLength() == null : this.getDataLength().equals(other.getDataLength()))
            && (this.getNotNull() == null ? other.getNotNull() == null : this.getNotNull().equals(other.getNotNull()))
            && (this.getIsOfUniq() == null ? other.getIsOfUniq() == null : this.getIsOfUniq().equals(other.getIsOfUniq()))
            && (this.getConfigOrder() == null ? other.getConfigOrder() == null : this.getConfigOrder().equals(other.getConfigOrder()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getRecStatus() == null ? other.getRecStatus() == null : this.getRecStatus().equals(other.getRecStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParamName() == null) ? 0 : getParamName().hashCode());
        result = prime * result + ((getConfigName() == null) ? 0 : getConfigName().hashCode());
        result = prime * result + ((getDataType() == null) ? 0 : getDataType().hashCode());
        result = prime * result + ((getShowName() == null) ? 0 : getShowName().hashCode());
        result = prime * result + ((getDataLength() == null) ? 0 : getDataLength().hashCode());
        result = prime * result + ((getNotNull() == null) ? 0 : getNotNull().hashCode());
        result = prime * result + ((getIsOfUniq() == null) ? 0 : getIsOfUniq().hashCode());
        result = prime * result + ((getConfigOrder() == null) ? 0 : getConfigOrder().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getRecStatus() == null) ? 0 : getRecStatus().hashCode());
        return result;
    }
}