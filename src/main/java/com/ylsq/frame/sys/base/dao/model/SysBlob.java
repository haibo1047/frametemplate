package com.ylsq.frame.sys.base.dao.model;

import java.io.Serializable;
import java.util.Arrays;

public class SysBlob implements Serializable {
    /**
     * 编号
     *
     * @mbg.generated
     */
    private Long blobId;

    /**
     * 业务id
     *
     * @mbg.generated
     */
    private Long businessId;

    /**
     * 数据
     *
     * @mbg.generated
     */
    private byte[] data;

    private static final long serialVersionUID = 1L;

    public Long getBlobId() {
        return blobId;
    }

    public void setBlobId(Long blobId) {
        this.blobId = blobId;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", blobId=").append(blobId);
        sb.append(", businessId=").append(businessId);
        sb.append(", data=").append(data);
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
        SysBlob other = (SysBlob) that;
        return (this.getBlobId() == null ? other.getBlobId() == null : this.getBlobId().equals(other.getBlobId()))
            && (this.getBusinessId() == null ? other.getBusinessId() == null : this.getBusinessId().equals(other.getBusinessId()))
            && (Arrays.equals(this.getData(), other.getData()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBlobId() == null) ? 0 : getBlobId().hashCode());
        result = prime * result + ((getBusinessId() == null) ? 0 : getBusinessId().hashCode());
        result = prime * result + (Arrays.hashCode(getData()));
        return result;
    }
}