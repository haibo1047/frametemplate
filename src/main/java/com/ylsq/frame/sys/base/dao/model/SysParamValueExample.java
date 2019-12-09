package com.ylsq.frame.sys.base.dao.model;

import com.ylsq.frame.common.base.BaseExample;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysParamValueExample implements BaseExample, Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public SysParamValueExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNull() {
            addCriterion("param_name is null");
            return (Criteria) this;
        }

        public Criteria andParamNameIsNotNull() {
            addCriterion("param_name is not null");
            return (Criteria) this;
        }

        public Criteria andParamNameEqualTo(String value) {
            addCriterion("param_name =", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotEqualTo(String value) {
            addCriterion("param_name <>", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThan(String value) {
            addCriterion("param_name >", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameGreaterThanOrEqualTo(String value) {
            addCriterion("param_name >=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThan(String value) {
            addCriterion("param_name <", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLessThanOrEqualTo(String value) {
            addCriterion("param_name <=", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameLike(String value) {
            addCriterion("param_name like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotLike(String value) {
            addCriterion("param_name not like", value, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameIn(List<String> values) {
            addCriterion("param_name in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotIn(List<String> values) {
            addCriterion("param_name not in", values, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameBetween(String value1, String value2) {
            addCriterion("param_name between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andParamNameNotBetween(String value1, String value2) {
            addCriterion("param_name not between", value1, value2, "paramName");
            return (Criteria) this;
        }

        public Criteria andValue1IsNull() {
            addCriterion("value_1 is null");
            return (Criteria) this;
        }

        public Criteria andValue1IsNotNull() {
            addCriterion("value_1 is not null");
            return (Criteria) this;
        }

        public Criteria andValue1EqualTo(String value) {
            addCriterion("value_1 =", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotEqualTo(String value) {
            addCriterion("value_1 <>", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1GreaterThan(String value) {
            addCriterion("value_1 >", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1GreaterThanOrEqualTo(String value) {
            addCriterion("value_1 >=", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1LessThan(String value) {
            addCriterion("value_1 <", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1LessThanOrEqualTo(String value) {
            addCriterion("value_1 <=", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1Like(String value) {
            addCriterion("value_1 like", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotLike(String value) {
            addCriterion("value_1 not like", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1In(List<String> values) {
            addCriterion("value_1 in", values, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotIn(List<String> values) {
            addCriterion("value_1 not in", values, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1Between(String value1, String value2) {
            addCriterion("value_1 between", value1, value2, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotBetween(String value1, String value2) {
            addCriterion("value_1 not between", value1, value2, "value1");
            return (Criteria) this;
        }

        public Criteria andValue2IsNull() {
            addCriterion("value_2 is null");
            return (Criteria) this;
        }

        public Criteria andValue2IsNotNull() {
            addCriterion("value_2 is not null");
            return (Criteria) this;
        }

        public Criteria andValue2EqualTo(String value) {
            addCriterion("value_2 =", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotEqualTo(String value) {
            addCriterion("value_2 <>", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2GreaterThan(String value) {
            addCriterion("value_2 >", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2GreaterThanOrEqualTo(String value) {
            addCriterion("value_2 >=", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2LessThan(String value) {
            addCriterion("value_2 <", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2LessThanOrEqualTo(String value) {
            addCriterion("value_2 <=", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2Like(String value) {
            addCriterion("value_2 like", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotLike(String value) {
            addCriterion("value_2 not like", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2In(List<String> values) {
            addCriterion("value_2 in", values, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotIn(List<String> values) {
            addCriterion("value_2 not in", values, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2Between(String value1, String value2) {
            addCriterion("value_2 between", value1, value2, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotBetween(String value1, String value2) {
            addCriterion("value_2 not between", value1, value2, "value2");
            return (Criteria) this;
        }

        public Criteria andValue3IsNull() {
            addCriterion("value_3 is null");
            return (Criteria) this;
        }

        public Criteria andValue3IsNotNull() {
            addCriterion("value_3 is not null");
            return (Criteria) this;
        }

        public Criteria andValue3EqualTo(String value) {
            addCriterion("value_3 =", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3NotEqualTo(String value) {
            addCriterion("value_3 <>", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3GreaterThan(String value) {
            addCriterion("value_3 >", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3GreaterThanOrEqualTo(String value) {
            addCriterion("value_3 >=", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3LessThan(String value) {
            addCriterion("value_3 <", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3LessThanOrEqualTo(String value) {
            addCriterion("value_3 <=", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3Like(String value) {
            addCriterion("value_3 like", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3NotLike(String value) {
            addCriterion("value_3 not like", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3In(List<String> values) {
            addCriterion("value_3 in", values, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3NotIn(List<String> values) {
            addCriterion("value_3 not in", values, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3Between(String value1, String value2) {
            addCriterion("value_3 between", value1, value2, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3NotBetween(String value1, String value2) {
            addCriterion("value_3 not between", value1, value2, "value3");
            return (Criteria) this;
        }

        public Criteria andValue4IsNull() {
            addCriterion("value_4 is null");
            return (Criteria) this;
        }

        public Criteria andValue4IsNotNull() {
            addCriterion("value_4 is not null");
            return (Criteria) this;
        }

        public Criteria andValue4EqualTo(String value) {
            addCriterion("value_4 =", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4NotEqualTo(String value) {
            addCriterion("value_4 <>", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4GreaterThan(String value) {
            addCriterion("value_4 >", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4GreaterThanOrEqualTo(String value) {
            addCriterion("value_4 >=", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4LessThan(String value) {
            addCriterion("value_4 <", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4LessThanOrEqualTo(String value) {
            addCriterion("value_4 <=", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4Like(String value) {
            addCriterion("value_4 like", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4NotLike(String value) {
            addCriterion("value_4 not like", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4In(List<String> values) {
            addCriterion("value_4 in", values, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4NotIn(List<String> values) {
            addCriterion("value_4 not in", values, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4Between(String value1, String value2) {
            addCriterion("value_4 between", value1, value2, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4NotBetween(String value1, String value2) {
            addCriterion("value_4 not between", value1, value2, "value4");
            return (Criteria) this;
        }

        public Criteria andValue5IsNull() {
            addCriterion("value_5 is null");
            return (Criteria) this;
        }

        public Criteria andValue5IsNotNull() {
            addCriterion("value_5 is not null");
            return (Criteria) this;
        }

        public Criteria andValue5EqualTo(String value) {
            addCriterion("value_5 =", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5NotEqualTo(String value) {
            addCriterion("value_5 <>", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5GreaterThan(String value) {
            addCriterion("value_5 >", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5GreaterThanOrEqualTo(String value) {
            addCriterion("value_5 >=", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5LessThan(String value) {
            addCriterion("value_5 <", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5LessThanOrEqualTo(String value) {
            addCriterion("value_5 <=", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5Like(String value) {
            addCriterion("value_5 like", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5NotLike(String value) {
            addCriterion("value_5 not like", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5In(List<String> values) {
            addCriterion("value_5 in", values, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5NotIn(List<String> values) {
            addCriterion("value_5 not in", values, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5Between(String value1, String value2) {
            addCriterion("value_5 between", value1, value2, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5NotBetween(String value1, String value2) {
            addCriterion("value_5 not between", value1, value2, "value5");
            return (Criteria) this;
        }

        public Criteria andValue6IsNull() {
            addCriterion("value_6 is null");
            return (Criteria) this;
        }

        public Criteria andValue6IsNotNull() {
            addCriterion("value_6 is not null");
            return (Criteria) this;
        }

        public Criteria andValue6EqualTo(String value) {
            addCriterion("value_6 =", value, "value6");
            return (Criteria) this;
        }

        public Criteria andValue6NotEqualTo(String value) {
            addCriterion("value_6 <>", value, "value6");
            return (Criteria) this;
        }

        public Criteria andValue6GreaterThan(String value) {
            addCriterion("value_6 >", value, "value6");
            return (Criteria) this;
        }

        public Criteria andValue6GreaterThanOrEqualTo(String value) {
            addCriterion("value_6 >=", value, "value6");
            return (Criteria) this;
        }

        public Criteria andValue6LessThan(String value) {
            addCriterion("value_6 <", value, "value6");
            return (Criteria) this;
        }

        public Criteria andValue6LessThanOrEqualTo(String value) {
            addCriterion("value_6 <=", value, "value6");
            return (Criteria) this;
        }

        public Criteria andValue6Like(String value) {
            addCriterion("value_6 like", value, "value6");
            return (Criteria) this;
        }

        public Criteria andValue6NotLike(String value) {
            addCriterion("value_6 not like", value, "value6");
            return (Criteria) this;
        }

        public Criteria andValue6In(List<String> values) {
            addCriterion("value_6 in", values, "value6");
            return (Criteria) this;
        }

        public Criteria andValue6NotIn(List<String> values) {
            addCriterion("value_6 not in", values, "value6");
            return (Criteria) this;
        }

        public Criteria andValue6Between(String value1, String value2) {
            addCriterion("value_6 between", value1, value2, "value6");
            return (Criteria) this;
        }

        public Criteria andValue6NotBetween(String value1, String value2) {
            addCriterion("value_6 not between", value1, value2, "value6");
            return (Criteria) this;
        }

        public Criteria andValue7IsNull() {
            addCriterion("value_7 is null");
            return (Criteria) this;
        }

        public Criteria andValue7IsNotNull() {
            addCriterion("value_7 is not null");
            return (Criteria) this;
        }

        public Criteria andValue7EqualTo(String value) {
            addCriterion("value_7 =", value, "value7");
            return (Criteria) this;
        }

        public Criteria andValue7NotEqualTo(String value) {
            addCriterion("value_7 <>", value, "value7");
            return (Criteria) this;
        }

        public Criteria andValue7GreaterThan(String value) {
            addCriterion("value_7 >", value, "value7");
            return (Criteria) this;
        }

        public Criteria andValue7GreaterThanOrEqualTo(String value) {
            addCriterion("value_7 >=", value, "value7");
            return (Criteria) this;
        }

        public Criteria andValue7LessThan(String value) {
            addCriterion("value_7 <", value, "value7");
            return (Criteria) this;
        }

        public Criteria andValue7LessThanOrEqualTo(String value) {
            addCriterion("value_7 <=", value, "value7");
            return (Criteria) this;
        }

        public Criteria andValue7Like(String value) {
            addCriterion("value_7 like", value, "value7");
            return (Criteria) this;
        }

        public Criteria andValue7NotLike(String value) {
            addCriterion("value_7 not like", value, "value7");
            return (Criteria) this;
        }

        public Criteria andValue7In(List<String> values) {
            addCriterion("value_7 in", values, "value7");
            return (Criteria) this;
        }

        public Criteria andValue7NotIn(List<String> values) {
            addCriterion("value_7 not in", values, "value7");
            return (Criteria) this;
        }

        public Criteria andValue7Between(String value1, String value2) {
            addCriterion("value_7 between", value1, value2, "value7");
            return (Criteria) this;
        }

        public Criteria andValue7NotBetween(String value1, String value2) {
            addCriterion("value_7 not between", value1, value2, "value7");
            return (Criteria) this;
        }

        public Criteria andValue8IsNull() {
            addCriterion("value_8 is null");
            return (Criteria) this;
        }

        public Criteria andValue8IsNotNull() {
            addCriterion("value_8 is not null");
            return (Criteria) this;
        }

        public Criteria andValue8EqualTo(String value) {
            addCriterion("value_8 =", value, "value8");
            return (Criteria) this;
        }

        public Criteria andValue8NotEqualTo(String value) {
            addCriterion("value_8 <>", value, "value8");
            return (Criteria) this;
        }

        public Criteria andValue8GreaterThan(String value) {
            addCriterion("value_8 >", value, "value8");
            return (Criteria) this;
        }

        public Criteria andValue8GreaterThanOrEqualTo(String value) {
            addCriterion("value_8 >=", value, "value8");
            return (Criteria) this;
        }

        public Criteria andValue8LessThan(String value) {
            addCriterion("value_8 <", value, "value8");
            return (Criteria) this;
        }

        public Criteria andValue8LessThanOrEqualTo(String value) {
            addCriterion("value_8 <=", value, "value8");
            return (Criteria) this;
        }

        public Criteria andValue8Like(String value) {
            addCriterion("value_8 like", value, "value8");
            return (Criteria) this;
        }

        public Criteria andValue8NotLike(String value) {
            addCriterion("value_8 not like", value, "value8");
            return (Criteria) this;
        }

        public Criteria andValue8In(List<String> values) {
            addCriterion("value_8 in", values, "value8");
            return (Criteria) this;
        }

        public Criteria andValue8NotIn(List<String> values) {
            addCriterion("value_8 not in", values, "value8");
            return (Criteria) this;
        }

        public Criteria andValue8Between(String value1, String value2) {
            addCriterion("value_8 between", value1, value2, "value8");
            return (Criteria) this;
        }

        public Criteria andValue8NotBetween(String value1, String value2) {
            addCriterion("value_8 not between", value1, value2, "value8");
            return (Criteria) this;
        }

        public Criteria andValue9IsNull() {
            addCriterion("value_9 is null");
            return (Criteria) this;
        }

        public Criteria andValue9IsNotNull() {
            addCriterion("value_9 is not null");
            return (Criteria) this;
        }

        public Criteria andValue9EqualTo(String value) {
            addCriterion("value_9 =", value, "value9");
            return (Criteria) this;
        }

        public Criteria andValue9NotEqualTo(String value) {
            addCriterion("value_9 <>", value, "value9");
            return (Criteria) this;
        }

        public Criteria andValue9GreaterThan(String value) {
            addCriterion("value_9 >", value, "value9");
            return (Criteria) this;
        }

        public Criteria andValue9GreaterThanOrEqualTo(String value) {
            addCriterion("value_9 >=", value, "value9");
            return (Criteria) this;
        }

        public Criteria andValue9LessThan(String value) {
            addCriterion("value_9 <", value, "value9");
            return (Criteria) this;
        }

        public Criteria andValue9LessThanOrEqualTo(String value) {
            addCriterion("value_9 <=", value, "value9");
            return (Criteria) this;
        }

        public Criteria andValue9Like(String value) {
            addCriterion("value_9 like", value, "value9");
            return (Criteria) this;
        }

        public Criteria andValue9NotLike(String value) {
            addCriterion("value_9 not like", value, "value9");
            return (Criteria) this;
        }

        public Criteria andValue9In(List<String> values) {
            addCriterion("value_9 in", values, "value9");
            return (Criteria) this;
        }

        public Criteria andValue9NotIn(List<String> values) {
            addCriterion("value_9 not in", values, "value9");
            return (Criteria) this;
        }

        public Criteria andValue9Between(String value1, String value2) {
            addCriterion("value_9 between", value1, value2, "value9");
            return (Criteria) this;
        }

        public Criteria andValue9NotBetween(String value1, String value2) {
            addCriterion("value_9 not between", value1, value2, "value9");
            return (Criteria) this;
        }

        public Criteria andValue10IsNull() {
            addCriterion("value_10 is null");
            return (Criteria) this;
        }

        public Criteria andValue10IsNotNull() {
            addCriterion("value_10 is not null");
            return (Criteria) this;
        }

        public Criteria andValue10EqualTo(String value) {
            addCriterion("value_10 =", value, "value10");
            return (Criteria) this;
        }

        public Criteria andValue10NotEqualTo(String value) {
            addCriterion("value_10 <>", value, "value10");
            return (Criteria) this;
        }

        public Criteria andValue10GreaterThan(String value) {
            addCriterion("value_10 >", value, "value10");
            return (Criteria) this;
        }

        public Criteria andValue10GreaterThanOrEqualTo(String value) {
            addCriterion("value_10 >=", value, "value10");
            return (Criteria) this;
        }

        public Criteria andValue10LessThan(String value) {
            addCriterion("value_10 <", value, "value10");
            return (Criteria) this;
        }

        public Criteria andValue10LessThanOrEqualTo(String value) {
            addCriterion("value_10 <=", value, "value10");
            return (Criteria) this;
        }

        public Criteria andValue10Like(String value) {
            addCriterion("value_10 like", value, "value10");
            return (Criteria) this;
        }

        public Criteria andValue10NotLike(String value) {
            addCriterion("value_10 not like", value, "value10");
            return (Criteria) this;
        }

        public Criteria andValue10In(List<String> values) {
            addCriterion("value_10 in", values, "value10");
            return (Criteria) this;
        }

        public Criteria andValue10NotIn(List<String> values) {
            addCriterion("value_10 not in", values, "value10");
            return (Criteria) this;
        }

        public Criteria andValue10Between(String value1, String value2) {
            addCriterion("value_10 between", value1, value2, "value10");
            return (Criteria) this;
        }

        public Criteria andValue10NotBetween(String value1, String value2) {
            addCriterion("value_10 not between", value1, value2, "value10");
            return (Criteria) this;
        }

        public Criteria andValue11IsNull() {
            addCriterion("value_11 is null");
            return (Criteria) this;
        }

        public Criteria andValue11IsNotNull() {
            addCriterion("value_11 is not null");
            return (Criteria) this;
        }

        public Criteria andValue11EqualTo(String value) {
            addCriterion("value_11 =", value, "value11");
            return (Criteria) this;
        }

        public Criteria andValue11NotEqualTo(String value) {
            addCriterion("value_11 <>", value, "value11");
            return (Criteria) this;
        }

        public Criteria andValue11GreaterThan(String value) {
            addCriterion("value_11 >", value, "value11");
            return (Criteria) this;
        }

        public Criteria andValue11GreaterThanOrEqualTo(String value) {
            addCriterion("value_11 >=", value, "value11");
            return (Criteria) this;
        }

        public Criteria andValue11LessThan(String value) {
            addCriterion("value_11 <", value, "value11");
            return (Criteria) this;
        }

        public Criteria andValue11LessThanOrEqualTo(String value) {
            addCriterion("value_11 <=", value, "value11");
            return (Criteria) this;
        }

        public Criteria andValue11Like(String value) {
            addCriterion("value_11 like", value, "value11");
            return (Criteria) this;
        }

        public Criteria andValue11NotLike(String value) {
            addCriterion("value_11 not like", value, "value11");
            return (Criteria) this;
        }

        public Criteria andValue11In(List<String> values) {
            addCriterion("value_11 in", values, "value11");
            return (Criteria) this;
        }

        public Criteria andValue11NotIn(List<String> values) {
            addCriterion("value_11 not in", values, "value11");
            return (Criteria) this;
        }

        public Criteria andValue11Between(String value1, String value2) {
            addCriterion("value_11 between", value1, value2, "value11");
            return (Criteria) this;
        }

        public Criteria andValue11NotBetween(String value1, String value2) {
            addCriterion("value_11 not between", value1, value2, "value11");
            return (Criteria) this;
        }

        public Criteria andValue12IsNull() {
            addCriterion("value_12 is null");
            return (Criteria) this;
        }

        public Criteria andValue12IsNotNull() {
            addCriterion("value_12 is not null");
            return (Criteria) this;
        }

        public Criteria andValue12EqualTo(String value) {
            addCriterion("value_12 =", value, "value12");
            return (Criteria) this;
        }

        public Criteria andValue12NotEqualTo(String value) {
            addCriterion("value_12 <>", value, "value12");
            return (Criteria) this;
        }

        public Criteria andValue12GreaterThan(String value) {
            addCriterion("value_12 >", value, "value12");
            return (Criteria) this;
        }

        public Criteria andValue12GreaterThanOrEqualTo(String value) {
            addCriterion("value_12 >=", value, "value12");
            return (Criteria) this;
        }

        public Criteria andValue12LessThan(String value) {
            addCriterion("value_12 <", value, "value12");
            return (Criteria) this;
        }

        public Criteria andValue12LessThanOrEqualTo(String value) {
            addCriterion("value_12 <=", value, "value12");
            return (Criteria) this;
        }

        public Criteria andValue12Like(String value) {
            addCriterion("value_12 like", value, "value12");
            return (Criteria) this;
        }

        public Criteria andValue12NotLike(String value) {
            addCriterion("value_12 not like", value, "value12");
            return (Criteria) this;
        }

        public Criteria andValue12In(List<String> values) {
            addCriterion("value_12 in", values, "value12");
            return (Criteria) this;
        }

        public Criteria andValue12NotIn(List<String> values) {
            addCriterion("value_12 not in", values, "value12");
            return (Criteria) this;
        }

        public Criteria andValue12Between(String value1, String value2) {
            addCriterion("value_12 between", value1, value2, "value12");
            return (Criteria) this;
        }

        public Criteria andValue12NotBetween(String value1, String value2) {
            addCriterion("value_12 not between", value1, value2, "value12");
            return (Criteria) this;
        }

        public Criteria andValue13IsNull() {
            addCriterion("value_13 is null");
            return (Criteria) this;
        }

        public Criteria andValue13IsNotNull() {
            addCriterion("value_13 is not null");
            return (Criteria) this;
        }

        public Criteria andValue13EqualTo(String value) {
            addCriterion("value_13 =", value, "value13");
            return (Criteria) this;
        }

        public Criteria andValue13NotEqualTo(String value) {
            addCriterion("value_13 <>", value, "value13");
            return (Criteria) this;
        }

        public Criteria andValue13GreaterThan(String value) {
            addCriterion("value_13 >", value, "value13");
            return (Criteria) this;
        }

        public Criteria andValue13GreaterThanOrEqualTo(String value) {
            addCriterion("value_13 >=", value, "value13");
            return (Criteria) this;
        }

        public Criteria andValue13LessThan(String value) {
            addCriterion("value_13 <", value, "value13");
            return (Criteria) this;
        }

        public Criteria andValue13LessThanOrEqualTo(String value) {
            addCriterion("value_13 <=", value, "value13");
            return (Criteria) this;
        }

        public Criteria andValue13Like(String value) {
            addCriterion("value_13 like", value, "value13");
            return (Criteria) this;
        }

        public Criteria andValue13NotLike(String value) {
            addCriterion("value_13 not like", value, "value13");
            return (Criteria) this;
        }

        public Criteria andValue13In(List<String> values) {
            addCriterion("value_13 in", values, "value13");
            return (Criteria) this;
        }

        public Criteria andValue13NotIn(List<String> values) {
            addCriterion("value_13 not in", values, "value13");
            return (Criteria) this;
        }

        public Criteria andValue13Between(String value1, String value2) {
            addCriterion("value_13 between", value1, value2, "value13");
            return (Criteria) this;
        }

        public Criteria andValue13NotBetween(String value1, String value2) {
            addCriterion("value_13 not between", value1, value2, "value13");
            return (Criteria) this;
        }

        public Criteria andValue14IsNull() {
            addCriterion("value_14 is null");
            return (Criteria) this;
        }

        public Criteria andValue14IsNotNull() {
            addCriterion("value_14 is not null");
            return (Criteria) this;
        }

        public Criteria andValue14EqualTo(String value) {
            addCriterion("value_14 =", value, "value14");
            return (Criteria) this;
        }

        public Criteria andValue14NotEqualTo(String value) {
            addCriterion("value_14 <>", value, "value14");
            return (Criteria) this;
        }

        public Criteria andValue14GreaterThan(String value) {
            addCriterion("value_14 >", value, "value14");
            return (Criteria) this;
        }

        public Criteria andValue14GreaterThanOrEqualTo(String value) {
            addCriterion("value_14 >=", value, "value14");
            return (Criteria) this;
        }

        public Criteria andValue14LessThan(String value) {
            addCriterion("value_14 <", value, "value14");
            return (Criteria) this;
        }

        public Criteria andValue14LessThanOrEqualTo(String value) {
            addCriterion("value_14 <=", value, "value14");
            return (Criteria) this;
        }

        public Criteria andValue14Like(String value) {
            addCriterion("value_14 like", value, "value14");
            return (Criteria) this;
        }

        public Criteria andValue14NotLike(String value) {
            addCriterion("value_14 not like", value, "value14");
            return (Criteria) this;
        }

        public Criteria andValue14In(List<String> values) {
            addCriterion("value_14 in", values, "value14");
            return (Criteria) this;
        }

        public Criteria andValue14NotIn(List<String> values) {
            addCriterion("value_14 not in", values, "value14");
            return (Criteria) this;
        }

        public Criteria andValue14Between(String value1, String value2) {
            addCriterion("value_14 between", value1, value2, "value14");
            return (Criteria) this;
        }

        public Criteria andValue14NotBetween(String value1, String value2) {
            addCriterion("value_14 not between", value1, value2, "value14");
            return (Criteria) this;
        }

        public Criteria andValue15IsNull() {
            addCriterion("value_15 is null");
            return (Criteria) this;
        }

        public Criteria andValue15IsNotNull() {
            addCriterion("value_15 is not null");
            return (Criteria) this;
        }

        public Criteria andValue15EqualTo(String value) {
            addCriterion("value_15 =", value, "value15");
            return (Criteria) this;
        }

        public Criteria andValue15NotEqualTo(String value) {
            addCriterion("value_15 <>", value, "value15");
            return (Criteria) this;
        }

        public Criteria andValue15GreaterThan(String value) {
            addCriterion("value_15 >", value, "value15");
            return (Criteria) this;
        }

        public Criteria andValue15GreaterThanOrEqualTo(String value) {
            addCriterion("value_15 >=", value, "value15");
            return (Criteria) this;
        }

        public Criteria andValue15LessThan(String value) {
            addCriterion("value_15 <", value, "value15");
            return (Criteria) this;
        }

        public Criteria andValue15LessThanOrEqualTo(String value) {
            addCriterion("value_15 <=", value, "value15");
            return (Criteria) this;
        }

        public Criteria andValue15Like(String value) {
            addCriterion("value_15 like", value, "value15");
            return (Criteria) this;
        }

        public Criteria andValue15NotLike(String value) {
            addCriterion("value_15 not like", value, "value15");
            return (Criteria) this;
        }

        public Criteria andValue15In(List<String> values) {
            addCriterion("value_15 in", values, "value15");
            return (Criteria) this;
        }

        public Criteria andValue15NotIn(List<String> values) {
            addCriterion("value_15 not in", values, "value15");
            return (Criteria) this;
        }

        public Criteria andValue15Between(String value1, String value2) {
            addCriterion("value_15 between", value1, value2, "value15");
            return (Criteria) this;
        }

        public Criteria andValue15NotBetween(String value1, String value2) {
            addCriterion("value_15 not between", value1, value2, "value15");
            return (Criteria) this;
        }

        public Criteria andValue16IsNull() {
            addCriterion("value_16 is null");
            return (Criteria) this;
        }

        public Criteria andValue16IsNotNull() {
            addCriterion("value_16 is not null");
            return (Criteria) this;
        }

        public Criteria andValue16EqualTo(String value) {
            addCriterion("value_16 =", value, "value16");
            return (Criteria) this;
        }

        public Criteria andValue16NotEqualTo(String value) {
            addCriterion("value_16 <>", value, "value16");
            return (Criteria) this;
        }

        public Criteria andValue16GreaterThan(String value) {
            addCriterion("value_16 >", value, "value16");
            return (Criteria) this;
        }

        public Criteria andValue16GreaterThanOrEqualTo(String value) {
            addCriterion("value_16 >=", value, "value16");
            return (Criteria) this;
        }

        public Criteria andValue16LessThan(String value) {
            addCriterion("value_16 <", value, "value16");
            return (Criteria) this;
        }

        public Criteria andValue16LessThanOrEqualTo(String value) {
            addCriterion("value_16 <=", value, "value16");
            return (Criteria) this;
        }

        public Criteria andValue16Like(String value) {
            addCriterion("value_16 like", value, "value16");
            return (Criteria) this;
        }

        public Criteria andValue16NotLike(String value) {
            addCriterion("value_16 not like", value, "value16");
            return (Criteria) this;
        }

        public Criteria andValue16In(List<String> values) {
            addCriterion("value_16 in", values, "value16");
            return (Criteria) this;
        }

        public Criteria andValue16NotIn(List<String> values) {
            addCriterion("value_16 not in", values, "value16");
            return (Criteria) this;
        }

        public Criteria andValue16Between(String value1, String value2) {
            addCriterion("value_16 between", value1, value2, "value16");
            return (Criteria) this;
        }

        public Criteria andValue16NotBetween(String value1, String value2) {
            addCriterion("value_16 not between", value1, value2, "value16");
            return (Criteria) this;
        }

        public Criteria andValue17IsNull() {
            addCriterion("value_17 is null");
            return (Criteria) this;
        }

        public Criteria andValue17IsNotNull() {
            addCriterion("value_17 is not null");
            return (Criteria) this;
        }

        public Criteria andValue17EqualTo(String value) {
            addCriterion("value_17 =", value, "value17");
            return (Criteria) this;
        }

        public Criteria andValue17NotEqualTo(String value) {
            addCriterion("value_17 <>", value, "value17");
            return (Criteria) this;
        }

        public Criteria andValue17GreaterThan(String value) {
            addCriterion("value_17 >", value, "value17");
            return (Criteria) this;
        }

        public Criteria andValue17GreaterThanOrEqualTo(String value) {
            addCriterion("value_17 >=", value, "value17");
            return (Criteria) this;
        }

        public Criteria andValue17LessThan(String value) {
            addCriterion("value_17 <", value, "value17");
            return (Criteria) this;
        }

        public Criteria andValue17LessThanOrEqualTo(String value) {
            addCriterion("value_17 <=", value, "value17");
            return (Criteria) this;
        }

        public Criteria andValue17Like(String value) {
            addCriterion("value_17 like", value, "value17");
            return (Criteria) this;
        }

        public Criteria andValue17NotLike(String value) {
            addCriterion("value_17 not like", value, "value17");
            return (Criteria) this;
        }

        public Criteria andValue17In(List<String> values) {
            addCriterion("value_17 in", values, "value17");
            return (Criteria) this;
        }

        public Criteria andValue17NotIn(List<String> values) {
            addCriterion("value_17 not in", values, "value17");
            return (Criteria) this;
        }

        public Criteria andValue17Between(String value1, String value2) {
            addCriterion("value_17 between", value1, value2, "value17");
            return (Criteria) this;
        }

        public Criteria andValue17NotBetween(String value1, String value2) {
            addCriterion("value_17 not between", value1, value2, "value17");
            return (Criteria) this;
        }

        public Criteria andValue18IsNull() {
            addCriterion("value_18 is null");
            return (Criteria) this;
        }

        public Criteria andValue18IsNotNull() {
            addCriterion("value_18 is not null");
            return (Criteria) this;
        }

        public Criteria andValue18EqualTo(String value) {
            addCriterion("value_18 =", value, "value18");
            return (Criteria) this;
        }

        public Criteria andValue18NotEqualTo(String value) {
            addCriterion("value_18 <>", value, "value18");
            return (Criteria) this;
        }

        public Criteria andValue18GreaterThan(String value) {
            addCriterion("value_18 >", value, "value18");
            return (Criteria) this;
        }

        public Criteria andValue18GreaterThanOrEqualTo(String value) {
            addCriterion("value_18 >=", value, "value18");
            return (Criteria) this;
        }

        public Criteria andValue18LessThan(String value) {
            addCriterion("value_18 <", value, "value18");
            return (Criteria) this;
        }

        public Criteria andValue18LessThanOrEqualTo(String value) {
            addCriterion("value_18 <=", value, "value18");
            return (Criteria) this;
        }

        public Criteria andValue18Like(String value) {
            addCriterion("value_18 like", value, "value18");
            return (Criteria) this;
        }

        public Criteria andValue18NotLike(String value) {
            addCriterion("value_18 not like", value, "value18");
            return (Criteria) this;
        }

        public Criteria andValue18In(List<String> values) {
            addCriterion("value_18 in", values, "value18");
            return (Criteria) this;
        }

        public Criteria andValue18NotIn(List<String> values) {
            addCriterion("value_18 not in", values, "value18");
            return (Criteria) this;
        }

        public Criteria andValue18Between(String value1, String value2) {
            addCriterion("value_18 between", value1, value2, "value18");
            return (Criteria) this;
        }

        public Criteria andValue18NotBetween(String value1, String value2) {
            addCriterion("value_18 not between", value1, value2, "value18");
            return (Criteria) this;
        }

        public Criteria andValue19IsNull() {
            addCriterion("value_19 is null");
            return (Criteria) this;
        }

        public Criteria andValue19IsNotNull() {
            addCriterion("value_19 is not null");
            return (Criteria) this;
        }

        public Criteria andValue19EqualTo(String value) {
            addCriterion("value_19 =", value, "value19");
            return (Criteria) this;
        }

        public Criteria andValue19NotEqualTo(String value) {
            addCriterion("value_19 <>", value, "value19");
            return (Criteria) this;
        }

        public Criteria andValue19GreaterThan(String value) {
            addCriterion("value_19 >", value, "value19");
            return (Criteria) this;
        }

        public Criteria andValue19GreaterThanOrEqualTo(String value) {
            addCriterion("value_19 >=", value, "value19");
            return (Criteria) this;
        }

        public Criteria andValue19LessThan(String value) {
            addCriterion("value_19 <", value, "value19");
            return (Criteria) this;
        }

        public Criteria andValue19LessThanOrEqualTo(String value) {
            addCriterion("value_19 <=", value, "value19");
            return (Criteria) this;
        }

        public Criteria andValue19Like(String value) {
            addCriterion("value_19 like", value, "value19");
            return (Criteria) this;
        }

        public Criteria andValue19NotLike(String value) {
            addCriterion("value_19 not like", value, "value19");
            return (Criteria) this;
        }

        public Criteria andValue19In(List<String> values) {
            addCriterion("value_19 in", values, "value19");
            return (Criteria) this;
        }

        public Criteria andValue19NotIn(List<String> values) {
            addCriterion("value_19 not in", values, "value19");
            return (Criteria) this;
        }

        public Criteria andValue19Between(String value1, String value2) {
            addCriterion("value_19 between", value1, value2, "value19");
            return (Criteria) this;
        }

        public Criteria andValue19NotBetween(String value1, String value2) {
            addCriterion("value_19 not between", value1, value2, "value19");
            return (Criteria) this;
        }

        public Criteria andValue20IsNull() {
            addCriterion("value_20 is null");
            return (Criteria) this;
        }

        public Criteria andValue20IsNotNull() {
            addCriterion("value_20 is not null");
            return (Criteria) this;
        }

        public Criteria andValue20EqualTo(String value) {
            addCriterion("value_20 =", value, "value20");
            return (Criteria) this;
        }

        public Criteria andValue20NotEqualTo(String value) {
            addCriterion("value_20 <>", value, "value20");
            return (Criteria) this;
        }

        public Criteria andValue20GreaterThan(String value) {
            addCriterion("value_20 >", value, "value20");
            return (Criteria) this;
        }

        public Criteria andValue20GreaterThanOrEqualTo(String value) {
            addCriterion("value_20 >=", value, "value20");
            return (Criteria) this;
        }

        public Criteria andValue20LessThan(String value) {
            addCriterion("value_20 <", value, "value20");
            return (Criteria) this;
        }

        public Criteria andValue20LessThanOrEqualTo(String value) {
            addCriterion("value_20 <=", value, "value20");
            return (Criteria) this;
        }

        public Criteria andValue20Like(String value) {
            addCriterion("value_20 like", value, "value20");
            return (Criteria) this;
        }

        public Criteria andValue20NotLike(String value) {
            addCriterion("value_20 not like", value, "value20");
            return (Criteria) this;
        }

        public Criteria andValue20In(List<String> values) {
            addCriterion("value_20 in", values, "value20");
            return (Criteria) this;
        }

        public Criteria andValue20NotIn(List<String> values) {
            addCriterion("value_20 not in", values, "value20");
            return (Criteria) this;
        }

        public Criteria andValue20Between(String value1, String value2) {
            addCriterion("value_20 between", value1, value2, "value20");
            return (Criteria) this;
        }

        public Criteria andValue20NotBetween(String value1, String value2) {
            addCriterion("value_20 not between", value1, value2, "value20");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andRecStatusIsNull() {
            addCriterion("rec_status is null");
            return (Criteria) this;
        }

        public Criteria andRecStatusIsNotNull() {
            addCriterion("rec_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecStatusEqualTo(Integer value) {
            addCriterion("rec_status =", value, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusNotEqualTo(Integer value) {
            addCriterion("rec_status <>", value, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusGreaterThan(Integer value) {
            addCriterion("rec_status >", value, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("rec_status >=", value, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusLessThan(Integer value) {
            addCriterion("rec_status <", value, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusLessThanOrEqualTo(Integer value) {
            addCriterion("rec_status <=", value, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusIn(List<Integer> values) {
            addCriterion("rec_status in", values, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusNotIn(List<Integer> values) {
            addCriterion("rec_status not in", values, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusBetween(Integer value1, Integer value2) {
            addCriterion("rec_status between", value1, value2, "recStatus");
            return (Criteria) this;
        }

        public Criteria andRecStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("rec_status not between", value1, value2, "recStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}