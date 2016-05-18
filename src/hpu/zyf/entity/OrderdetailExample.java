package hpu.zyf.entity;
/**
 * 订单明细详情封装条件
 */
import java.util.ArrayList;
import java.util.List;

public class OrderdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderdetailExample() {
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

        public Criteria andOdidIsNull() {
            addCriterion("odid is null");
            return (Criteria) this;
        }

        public Criteria andOdidIsNotNull() {
            addCriterion("odid is not null");
            return (Criteria) this;
        }

        public Criteria andOdidEqualTo(String value) {
            addCriterion("odid =", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidNotEqualTo(String value) {
            addCriterion("odid <>", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidGreaterThan(String value) {
            addCriterion("odid >", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidGreaterThanOrEqualTo(String value) {
            addCriterion("odid >=", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidLessThan(String value) {
            addCriterion("odid <", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidLessThanOrEqualTo(String value) {
            addCriterion("odid <=", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidLike(String value) {
            addCriterion("odid like", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidNotLike(String value) {
            addCriterion("odid not like", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidIn(List<String> values) {
            addCriterion("odid in", values, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidNotIn(List<String> values) {
            addCriterion("odid not in", values, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidBetween(String value1, String value2) {
            addCriterion("odid between", value1, value2, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidNotBetween(String value1, String value2) {
            addCriterion("odid not between", value1, value2, "odid");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderid like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderid not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOdnumberIsNull() {
            addCriterion("odnumber is null");
            return (Criteria) this;
        }

        public Criteria andOdnumberIsNotNull() {
            addCriterion("odnumber is not null");
            return (Criteria) this;
        }

        public Criteria andOdnumberEqualTo(Integer value) {
            addCriterion("odnumber =", value, "odnumber");
            return (Criteria) this;
        }

        public Criteria andOdnumberNotEqualTo(Integer value) {
            addCriterion("odnumber <>", value, "odnumber");
            return (Criteria) this;
        }

        public Criteria andOdnumberGreaterThan(Integer value) {
            addCriterion("odnumber >", value, "odnumber");
            return (Criteria) this;
        }

        public Criteria andOdnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("odnumber >=", value, "odnumber");
            return (Criteria) this;
        }

        public Criteria andOdnumberLessThan(Integer value) {
            addCriterion("odnumber <", value, "odnumber");
            return (Criteria) this;
        }

        public Criteria andOdnumberLessThanOrEqualTo(Integer value) {
            addCriterion("odnumber <=", value, "odnumber");
            return (Criteria) this;
        }

        public Criteria andOdnumberIn(List<Integer> values) {
            addCriterion("odnumber in", values, "odnumber");
            return (Criteria) this;
        }

        public Criteria andOdnumberNotIn(List<Integer> values) {
            addCriterion("odnumber not in", values, "odnumber");
            return (Criteria) this;
        }

        public Criteria andOdnumberBetween(Integer value1, Integer value2) {
            addCriterion("odnumber between", value1, value2, "odnumber");
            return (Criteria) this;
        }

        public Criteria andOdnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("odnumber not between", value1, value2, "odnumber");
            return (Criteria) this;
        }

        public Criteria andOdpriceIsNull() {
            addCriterion("odprice is null");
            return (Criteria) this;
        }

        public Criteria andOdpriceIsNotNull() {
            addCriterion("odprice is not null");
            return (Criteria) this;
        }

        public Criteria andOdpriceEqualTo(Float value) {
            addCriterion("odprice =", value, "odprice");
            return (Criteria) this;
        }

        public Criteria andOdpriceNotEqualTo(Float value) {
            addCriterion("odprice <>", value, "odprice");
            return (Criteria) this;
        }

        public Criteria andOdpriceGreaterThan(Float value) {
            addCriterion("odprice >", value, "odprice");
            return (Criteria) this;
        }

        public Criteria andOdpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("odprice >=", value, "odprice");
            return (Criteria) this;
        }

        public Criteria andOdpriceLessThan(Float value) {
            addCriterion("odprice <", value, "odprice");
            return (Criteria) this;
        }

        public Criteria andOdpriceLessThanOrEqualTo(Float value) {
            addCriterion("odprice <=", value, "odprice");
            return (Criteria) this;
        }

        public Criteria andOdpriceIn(List<Float> values) {
            addCriterion("odprice in", values, "odprice");
            return (Criteria) this;
        }

        public Criteria andOdpriceNotIn(List<Float> values) {
            addCriterion("odprice not in", values, "odprice");
            return (Criteria) this;
        }

        public Criteria andOdpriceBetween(Float value1, Float value2) {
            addCriterion("odprice between", value1, value2, "odprice");
            return (Criteria) this;
        }

        public Criteria andOdpriceNotBetween(Float value1, Float value2) {
            addCriterion("odprice not between", value1, value2, "odprice");
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