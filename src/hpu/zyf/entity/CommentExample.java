package hpu.zyf.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/**
 * 评论封装条件
 * @author admin
 *
 */
public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommentidIsNull() {
            addCriterion("commentid is null");
            return (Criteria) this;
        }

        public Criteria andCommentidIsNotNull() {
            addCriterion("commentid is not null");
            return (Criteria) this;
        }

        public Criteria andCommentidEqualTo(String value) {
            addCriterion("commentid =", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotEqualTo(String value) {
            addCriterion("commentid <>", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidGreaterThan(String value) {
            addCriterion("commentid >", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidGreaterThanOrEqualTo(String value) {
            addCriterion("commentid >=", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLessThan(String value) {
            addCriterion("commentid <", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLessThanOrEqualTo(String value) {
            addCriterion("commentid <=", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidLike(String value) {
            addCriterion("commentid like", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotLike(String value) {
            addCriterion("commentid not like", value, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidIn(List<String> values) {
            addCriterion("commentid in", values, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotIn(List<String> values) {
            addCriterion("commentid not in", values, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidBetween(String value1, String value2) {
            addCriterion("commentid between", value1, value2, "commentid");
            return (Criteria) this;
        }

        public Criteria andCommentidNotBetween(String value1, String value2) {
            addCriterion("commentid not between", value1, value2, "commentid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCommentscoreIsNull() {
            addCriterion("commentscore is null");
            return (Criteria) this;
        }

        public Criteria andCommentscoreIsNotNull() {
            addCriterion("commentscore is not null");
            return (Criteria) this;
        }

        public Criteria andCommentscoreEqualTo(Float value) {
            addCriterion("commentscore =", value, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreNotEqualTo(Float value) {
            addCriterion("commentscore <>", value, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreGreaterThan(Float value) {
            addCriterion("commentscore >", value, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreGreaterThanOrEqualTo(Float value) {
            addCriterion("commentscore >=", value, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreLessThan(Float value) {
            addCriterion("commentscore <", value, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreLessThanOrEqualTo(Float value) {
            addCriterion("commentscore <=", value, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreIn(List<Float> values) {
            addCriterion("commentscore in", values, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreNotIn(List<Float> values) {
            addCriterion("commentscore not in", values, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreBetween(Float value1, Float value2) {
            addCriterion("commentscore between", value1, value2, "commentscore");
            return (Criteria) this;
        }

        public Criteria andCommentscoreNotBetween(Float value1, Float value2) {
            addCriterion("commentscore not between", value1, value2, "commentscore");
            return (Criteria) this;
        }

        public Criteria andConmmenttimeIsNull() {
            addCriterion("conmmenttime is null");
            return (Criteria) this;
        }

        public Criteria andConmmenttimeIsNotNull() {
            addCriterion("conmmenttime is not null");
            return (Criteria) this;
        }

        public Criteria andConmmenttimeEqualTo(Date value) {
            addCriterionForJDBCDate("conmmenttime =", value, "conmmenttime");
            return (Criteria) this;
        }

        public Criteria andConmmenttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("conmmenttime <>", value, "conmmenttime");
            return (Criteria) this;
        }

        public Criteria andConmmenttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("conmmenttime >", value, "conmmenttime");
            return (Criteria) this;
        }

        public Criteria andConmmenttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("conmmenttime >=", value, "conmmenttime");
            return (Criteria) this;
        }

        public Criteria andConmmenttimeLessThan(Date value) {
            addCriterionForJDBCDate("conmmenttime <", value, "conmmenttime");
            return (Criteria) this;
        }

        public Criteria andConmmenttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("conmmenttime <=", value, "conmmenttime");
            return (Criteria) this;
        }

        public Criteria andConmmenttimeIn(List<Date> values) {
            addCriterionForJDBCDate("conmmenttime in", values, "conmmenttime");
            return (Criteria) this;
        }

        public Criteria andConmmenttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("conmmenttime not in", values, "conmmenttime");
            return (Criteria) this;
        }

        public Criteria andConmmenttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("conmmenttime between", value1, value2, "conmmenttime");
            return (Criteria) this;
        }

        public Criteria andConmmenttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("conmmenttime not between", value1, value2, "conmmenttime");
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