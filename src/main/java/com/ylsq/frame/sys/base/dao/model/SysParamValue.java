package com.ylsq.frame.sys.base.dao.model;

import com.ylsq.frame.common.base.BaseModel;
import java.io.Serializable;
import java.util.Date;

public class SysParamValue implements BaseModel, Serializable {
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
     * value1
     *
     * @mbg.generated
     */
    private String value1;

    /**
     * value2
     *
     * @mbg.generated
     */
    private String value2;

    /**
     * value3
     *
     * @mbg.generated
     */
    private String value3;

    /**
     * value4
     *
     * @mbg.generated
     */
    private String value4;

    /**
     * value5
     *
     * @mbg.generated
     */
    private String value5;

    /**
     * value6
     *
     * @mbg.generated
     */
    private String value6;

    /**
     * value7
     *
     * @mbg.generated
     */
    private String value7;

    /**
     * value8
     *
     * @mbg.generated
     */
    private String value8;

    /**
     * value9
     *
     * @mbg.generated
     */
    private String value9;

    /**
     * value10
     *
     * @mbg.generated
     */
    private String value10;

    /**
     * value11
     *
     * @mbg.generated
     */
    private String value11;

    /**
     * value12
     *
     * @mbg.generated
     */
    private String value12;

    /**
     * value13
     *
     * @mbg.generated
     */
    private String value13;

    /**
     * value14
     *
     * @mbg.generated
     */
    private String value14;

    /**
     * value15
     *
     * @mbg.generated
     */
    private String value15;

    /**
     * value16
     *
     * @mbg.generated
     */
    private String value16;

    /**
     * value17
     *
     * @mbg.generated
     */
    private String value17;

    /**
     * value18
     *
     * @mbg.generated
     */
    private String value18;

    /**
     * value19
     *
     * @mbg.generated
     */
    private String value19;

    /**
     * value20
     *
     * @mbg.generated
     */
    private String value20;

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

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getValue4() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4 = value4;
    }

    public String getValue5() {
        return value5;
    }

    public void setValue5(String value5) {
        this.value5 = value5;
    }

    public String getValue6() {
        return value6;
    }

    public void setValue6(String value6) {
        this.value6 = value6;
    }

    public String getValue7() {
        return value7;
    }

    public void setValue7(String value7) {
        this.value7 = value7;
    }

    public String getValue8() {
        return value8;
    }

    public void setValue8(String value8) {
        this.value8 = value8;
    }

    public String getValue9() {
        return value9;
    }

    public void setValue9(String value9) {
        this.value9 = value9;
    }

    public String getValue10() {
        return value10;
    }

    public void setValue10(String value10) {
        this.value10 = value10;
    }

    public String getValue11() {
        return value11;
    }

    public void setValue11(String value11) {
        this.value11 = value11;
    }

    public String getValue12() {
        return value12;
    }

    public void setValue12(String value12) {
        this.value12 = value12;
    }

    public String getValue13() {
        return value13;
    }

    public void setValue13(String value13) {
        this.value13 = value13;
    }

    public String getValue14() {
        return value14;
    }

    public void setValue14(String value14) {
        this.value14 = value14;
    }

    public String getValue15() {
        return value15;
    }

    public void setValue15(String value15) {
        this.value15 = value15;
    }

    public String getValue16() {
        return value16;
    }

    public void setValue16(String value16) {
        this.value16 = value16;
    }

    public String getValue17() {
        return value17;
    }

    public void setValue17(String value17) {
        this.value17 = value17;
    }

    public String getValue18() {
        return value18;
    }

    public void setValue18(String value18) {
        this.value18 = value18;
    }

    public String getValue19() {
        return value19;
    }

    public void setValue19(String value19) {
        this.value19 = value19;
    }

    public String getValue20() {
        return value20;
    }

    public void setValue20(String value20) {
        this.value20 = value20;
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
        sb.append(", value1=").append(value1);
        sb.append(", value2=").append(value2);
        sb.append(", value3=").append(value3);
        sb.append(", value4=").append(value4);
        sb.append(", value5=").append(value5);
        sb.append(", value6=").append(value6);
        sb.append(", value7=").append(value7);
        sb.append(", value8=").append(value8);
        sb.append(", value9=").append(value9);
        sb.append(", value10=").append(value10);
        sb.append(", value11=").append(value11);
        sb.append(", value12=").append(value12);
        sb.append(", value13=").append(value13);
        sb.append(", value14=").append(value14);
        sb.append(", value15=").append(value15);
        sb.append(", value16=").append(value16);
        sb.append(", value17=").append(value17);
        sb.append(", value18=").append(value18);
        sb.append(", value19=").append(value19);
        sb.append(", value20=").append(value20);
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
        SysParamValue other = (SysParamValue) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParamName() == null ? other.getParamName() == null : this.getParamName().equals(other.getParamName()))
            && (this.getValue1() == null ? other.getValue1() == null : this.getValue1().equals(other.getValue1()))
            && (this.getValue2() == null ? other.getValue2() == null : this.getValue2().equals(other.getValue2()))
            && (this.getValue3() == null ? other.getValue3() == null : this.getValue3().equals(other.getValue3()))
            && (this.getValue4() == null ? other.getValue4() == null : this.getValue4().equals(other.getValue4()))
            && (this.getValue5() == null ? other.getValue5() == null : this.getValue5().equals(other.getValue5()))
            && (this.getValue6() == null ? other.getValue6() == null : this.getValue6().equals(other.getValue6()))
            && (this.getValue7() == null ? other.getValue7() == null : this.getValue7().equals(other.getValue7()))
            && (this.getValue8() == null ? other.getValue8() == null : this.getValue8().equals(other.getValue8()))
            && (this.getValue9() == null ? other.getValue9() == null : this.getValue9().equals(other.getValue9()))
            && (this.getValue10() == null ? other.getValue10() == null : this.getValue10().equals(other.getValue10()))
            && (this.getValue11() == null ? other.getValue11() == null : this.getValue11().equals(other.getValue11()))
            && (this.getValue12() == null ? other.getValue12() == null : this.getValue12().equals(other.getValue12()))
            && (this.getValue13() == null ? other.getValue13() == null : this.getValue13().equals(other.getValue13()))
            && (this.getValue14() == null ? other.getValue14() == null : this.getValue14().equals(other.getValue14()))
            && (this.getValue15() == null ? other.getValue15() == null : this.getValue15().equals(other.getValue15()))
            && (this.getValue16() == null ? other.getValue16() == null : this.getValue16().equals(other.getValue16()))
            && (this.getValue17() == null ? other.getValue17() == null : this.getValue17().equals(other.getValue17()))
            && (this.getValue18() == null ? other.getValue18() == null : this.getValue18().equals(other.getValue18()))
            && (this.getValue19() == null ? other.getValue19() == null : this.getValue19().equals(other.getValue19()))
            && (this.getValue20() == null ? other.getValue20() == null : this.getValue20().equals(other.getValue20()))
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
        result = prime * result + ((getValue1() == null) ? 0 : getValue1().hashCode());
        result = prime * result + ((getValue2() == null) ? 0 : getValue2().hashCode());
        result = prime * result + ((getValue3() == null) ? 0 : getValue3().hashCode());
        result = prime * result + ((getValue4() == null) ? 0 : getValue4().hashCode());
        result = prime * result + ((getValue5() == null) ? 0 : getValue5().hashCode());
        result = prime * result + ((getValue6() == null) ? 0 : getValue6().hashCode());
        result = prime * result + ((getValue7() == null) ? 0 : getValue7().hashCode());
        result = prime * result + ((getValue8() == null) ? 0 : getValue8().hashCode());
        result = prime * result + ((getValue9() == null) ? 0 : getValue9().hashCode());
        result = prime * result + ((getValue10() == null) ? 0 : getValue10().hashCode());
        result = prime * result + ((getValue11() == null) ? 0 : getValue11().hashCode());
        result = prime * result + ((getValue12() == null) ? 0 : getValue12().hashCode());
        result = prime * result + ((getValue13() == null) ? 0 : getValue13().hashCode());
        result = prime * result + ((getValue14() == null) ? 0 : getValue14().hashCode());
        result = prime * result + ((getValue15() == null) ? 0 : getValue15().hashCode());
        result = prime * result + ((getValue16() == null) ? 0 : getValue16().hashCode());
        result = prime * result + ((getValue17() == null) ? 0 : getValue17().hashCode());
        result = prime * result + ((getValue18() == null) ? 0 : getValue18().hashCode());
        result = prime * result + ((getValue19() == null) ? 0 : getValue19().hashCode());
        result = prime * result + ((getValue20() == null) ? 0 : getValue20().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getRecStatus() == null) ? 0 : getRecStatus().hashCode());
        return result;
    }
}