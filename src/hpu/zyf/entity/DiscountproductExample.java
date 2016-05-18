package hpu.zyf.entity;

import hpu.zyf.util.MyRowBounds;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/**
 * 打折商品封装条件
 * @author admin
 *
 */
public class DiscountproductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

  //引入分页的语句
    protected MyRowBounds rowBounds;
    

    public MyRowBounds getRowBounds() {
		return rowBounds;
	}

	public void setRowBounds(MyRowBounds rowBounds) {
		this.rowBounds = rowBounds;
	}
    
    public DiscountproductExample() {
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

    protected abstract static class GeneratedCriteria {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDisidIsNull() {
            addCriterion("disid is null");
            return (Criteria) this;
        }

        public Criteria andDisidIsNotNull() {
            addCriterion("disid is not null");
            return (Criteria) this;
        }

        public Criteria andDisidEqualTo(String value) {
            addCriterion("disid =", value, "disid");
            return (Criteria) this;
        }

        public Criteria andDisidNotEqualTo(String value) {
            addCriterion("disid <>", value, "disid");
            return (Criteria) this;
        }

        public Criteria andDisidGreaterThan(String value) {
            addCriterion("disid >", value, "disid");
            return (Criteria) this;
        }

        public Criteria andDisidGreaterThanOrEqualTo(String value) {
            addCriterion("disid >=", value, "disid");
            return (Criteria) this;
        }

        public Criteria andDisidLessThan(String value) {
            addCriterion("disid <", value, "disid");
            return (Criteria) this;
        }

        public Criteria andDisidLessThanOrEqualTo(String value) {
            addCriterion("disid <=", value, "disid");
            return (Criteria) this;
        }

        public Criteria andDisidLike(String value) {
            addCriterion("disid like", value, "disid");
            return (Criteria) this;
        }

        public Criteria andDisidNotLike(String value) {
            addCriterion("disid not like", value, "disid");
            return (Criteria) this;
        }

        public Criteria andDisidIn(List<String> values) {
            addCriterion("disid in", values, "disid");
            return (Criteria) this;
        }

        public Criteria andDisidNotIn(List<String> values) {
            addCriterion("disid not in", values, "disid");
            return (Criteria) this;
        }

        public Criteria andDisidBetween(String value1, String value2) {
            addCriterion("disid between", value1, value2, "disid");
            return (Criteria) this;
        }

        public Criteria andDisidNotBetween(String value1, String value2) {
            addCriterion("disid not between", value1, value2, "disid");
            return (Criteria) this;
        }

        public Criteria andPdidIsNull() {
            addCriterion("pdid is null");
            return (Criteria) this;
        }

        public Criteria andPdidIsNotNull() {
            addCriterion("pdid is not null");
            return (Criteria) this;
        }

        public Criteria andPdidEqualTo(String value) {
            addCriterion("pdid =", value, "pdid");
            return (Criteria) this;
        }

        public Criteria andPdidNotEqualTo(String value) {
            addCriterion("pdid <>", value, "pdid");
            return (Criteria) this;
        }

        public Criteria andPdidGreaterThan(String value) {
            addCriterion("pdid >", value, "pdid");
            return (Criteria) this;
        }

        public Criteria andPdidGreaterThanOrEqualTo(String value) {
            addCriterion("pdid >=", value, "pdid");
            return (Criteria) this;
        }

        public Criteria andPdidLessThan(String value) {
            addCriterion("pdid <", value, "pdid");
            return (Criteria) this;
        }

        public Criteria andPdidLessThanOrEqualTo(String value) {
            addCriterion("pdid <=", value, "pdid");
            return (Criteria) this;
        }

        public Criteria andPdidLike(String value) {
            addCriterion("pdid like", value, "pdid");
            return (Criteria) this;
        }

        public Criteria andPdidNotLike(String value) {
            addCriterion("pdid not like", value, "pdid");
            return (Criteria) this;
        }

        public Criteria andPdidIn(List<String> values) {
            addCriterion("pdid in", values, "pdid");
            return (Criteria) this;
        }

        public Criteria andPdidNotIn(List<String> values) {
            addCriterion("pdid not in", values, "pdid");
            return (Criteria) this;
        }

        public Criteria andPdidBetween(String value1, String value2) {
            addCriterion("pdid between", value1, value2, "pdid");
            return (Criteria) this;
        }

        public Criteria andPdidNotBetween(String value1, String value2) {
            addCriterion("pdid not between", value1, value2, "pdid");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterionForJDBCDate("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterionForJDBCDate("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterionForJDBCDate("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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