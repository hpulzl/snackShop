package hpu.zyf.entity;

import hpu.zyf.util.MyRowBounds;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/**
 * 商品明细封装条件
 * @author admin
 *
 */
public class ProductdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    //引入分页的语句
    protected MyRowBounds rowBounds;
    
    protected String pdtype;

    public String getPdType() {
		return pdtype;
	}

	public void setPdType(String pdtype) {
		this.pdtype = pdtype;
	}

	public MyRowBounds getRowBounds() {
		return rowBounds;
	}

	public void setRowBounds(MyRowBounds rowBounds) {
		this.rowBounds = rowBounds;
	}

	public ProductdetailExample() {
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

        public Criteria andPdtypeIsNull() {
            addCriterion("pdtype is null");
            return (Criteria) this;
        }

        public Criteria andPdtypeIsNotNull() {
            addCriterion("pdtype is not null");
            return (Criteria) this;
        }

        public Criteria andPdtypeEqualTo(String value) {
            addCriterion("pdtype =", value, "pdtype");
            return (Criteria) this;
        }

        public Criteria andPdtypeNotEqualTo(String value) {
            addCriterion("pdtype <>", value, "pdtype");
            return (Criteria) this;
        }

        public Criteria andPdtypeGreaterThan(String value) {
            addCriterion("pdtype >", value, "pdtype");
            return (Criteria) this;
        }

        public Criteria andPdtypeGreaterThanOrEqualTo(String value) {
            addCriterion("pdtype >=", value, "pdtype");
            return (Criteria) this;
        }

        public Criteria andPdtypeLessThan(String value) {
            addCriterion("pdtype <", value, "pdtype");
            return (Criteria) this;
        }

        public Criteria andPdtypeLessThanOrEqualTo(String value) {
            addCriterion("pdtype <=", value, "pdtype");
            return (Criteria) this;
        }

        public Criteria andPdtypeLike(String value) {
            addCriterion("pdtype like", value, "pdtype");
            return (Criteria) this;
        }

        public Criteria andPdtypeNotLike(String value) {
            addCriterion("pdtype not like", value, "pdtype");
            return (Criteria) this;
        }

        public Criteria andPdtypeIn(List<String> values) {
            addCriterion("pdtype in", values, "pdtype");
            return (Criteria) this;
        }

        public Criteria andPdtypeNotIn(List<String> values) {
            addCriterion("pdtype not in", values, "pdtype");
            return (Criteria) this;
        }

        public Criteria andPdtypeBetween(String value1, String value2) {
            addCriterion("pdtype between", value1, value2, "pdtype");
            return (Criteria) this;
        }

        public Criteria andPdtypeNotBetween(String value1, String value2) {
            addCriterion("pdtype not between", value1, value2, "pdtype");
            return (Criteria) this;
        }

        public Criteria andPdnameIsNull() {
            addCriterion("pdname is null");
            return (Criteria) this;
        }

        public Criteria andPdnameIsNotNull() {
            addCriterion("pdname is not null");
            return (Criteria) this;
        }

        public Criteria andPdnameEqualTo(String value) {
            addCriterion("pdname =", value, "pdname");
            return (Criteria) this;
        }

        public Criteria andPdnameNotEqualTo(String value) {
            addCriterion("pdname <>", value, "pdname");
            return (Criteria) this;
        }

        public Criteria andPdnameGreaterThan(String value) {
            addCriterion("pdname >", value, "pdname");
            return (Criteria) this;
        }

        public Criteria andPdnameGreaterThanOrEqualTo(String value) {
            addCriterion("pdname >=", value, "pdname");
            return (Criteria) this;
        }

        public Criteria andPdnameLessThan(String value) {
            addCriterion("pdname <", value, "pdname");
            return (Criteria) this;
        }

        public Criteria andPdnameLessThanOrEqualTo(String value) {
            addCriterion("pdname <=", value, "pdname");
            return (Criteria) this;
        }

        public Criteria andPdnameLike(String value) {
            addCriterion("pdname like", value, "pdname");
            return (Criteria) this;
        }

        public Criteria andPdnameNotLike(String value) {
            addCriterion("pdname not like", value, "pdname");
            return (Criteria) this;
        }

        public Criteria andPdnameIn(List<String> values) {
            addCriterion("pdname in", values, "pdname");
            return (Criteria) this;
        }

        public Criteria andPdnameNotIn(List<String> values) {
            addCriterion("pdname not in", values, "pdname");
            return (Criteria) this;
        }

        public Criteria andPdnameBetween(String value1, String value2) {
            addCriterion("pdname between", value1, value2, "pdname");
            return (Criteria) this;
        }

        public Criteria andPdnameNotBetween(String value1, String value2) {
            addCriterion("pdname not between", value1, value2, "pdname");
            return (Criteria) this;
        }

        public Criteria andPdpriceIsNull() {
            addCriterion("pdprice is null");
            return (Criteria) this;
        }

        public Criteria andPdpriceIsNotNull() {
            addCriterion("pdprice is not null");
            return (Criteria) this;
        }

        public Criteria andPdpriceEqualTo(Float value) {
            addCriterion("pdprice =", value, "pdprice");
            return (Criteria) this;
        }

        public Criteria andPdpriceNotEqualTo(Float value) {
            addCriterion("pdprice <>", value, "pdprice");
            return (Criteria) this;
        }

        public Criteria andPdpriceGreaterThan(Float value) {
            addCriterion("pdprice >", value, "pdprice");
            return (Criteria) this;
        }

        public Criteria andPdpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("pdprice >=", value, "pdprice");
            return (Criteria) this;
        }

        public Criteria andPdpriceLessThan(Float value) {
            addCriterion("pdprice <", value, "pdprice");
            return (Criteria) this;
        }

        public Criteria andPdpriceLessThanOrEqualTo(Float value) {
            addCriterion("pdprice <=", value, "pdprice");
            return (Criteria) this;
        }

        public Criteria andPdpriceIn(List<Float> values) {
            addCriterion("pdprice in", values, "pdprice");
            return (Criteria) this;
        }

        public Criteria andPdpriceNotIn(List<Float> values) {
            addCriterion("pdprice not in", values, "pdprice");
            return (Criteria) this;
        }

        public Criteria andPdpriceBetween(Float value1, Float value2) {
            addCriterion("pdprice between", value1, value2, "pdprice");
            return (Criteria) this;
        }

        public Criteria andPdpriceNotBetween(Float value1, Float value2) {
            addCriterion("pdprice not between", value1, value2, "pdprice");
            return (Criteria) this;
        }

        public Criteria andDispriceIsNull() {
            addCriterion("disprice is null");
            return (Criteria) this;
        }

        public Criteria andDispriceIsNotNull() {
            addCriterion("disprice is not null");
            return (Criteria) this;
        }

        public Criteria andDispriceEqualTo(Float value) {
            addCriterion("disprice =", value, "disprice");
            return (Criteria) this;
        }

        public Criteria andDispriceNotEqualTo(Float value) {
            addCriterion("disprice <>", value, "disprice");
            return (Criteria) this;
        }

        public Criteria andDispriceGreaterThan(Float value) {
            addCriterion("disprice >", value, "disprice");
            return (Criteria) this;
        }

        public Criteria andDispriceGreaterThanOrEqualTo(Float value) {
            addCriterion("disprice >=", value, "disprice");
            return (Criteria) this;
        }

        public Criteria andDispriceLessThan(Float value) {
            addCriterion("disprice <", value, "disprice");
            return (Criteria) this;
        }

        public Criteria andDispriceLessThanOrEqualTo(Float value) {
            addCriterion("disprice <=", value, "disprice");
            return (Criteria) this;
        }

        public Criteria andDispriceIn(List<Float> values) {
            addCriterion("disprice in", values, "disprice");
            return (Criteria) this;
        }

        public Criteria andDispriceNotIn(List<Float> values) {
            addCriterion("disprice not in", values, "disprice");
            return (Criteria) this;
        }

        public Criteria andDispriceBetween(Float value1, Float value2) {
            addCriterion("disprice between", value1, value2, "disprice");
            return (Criteria) this;
        }

        public Criteria andDispriceNotBetween(Float value1, Float value2) {
            addCriterion("disprice not between", value1, value2, "disprice");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andPdimageIsNull() {
            addCriterion("pdimage is null");
            return (Criteria) this;
        }

        public Criteria andPdimageIsNotNull() {
            addCriterion("pdimage is not null");
            return (Criteria) this;
        }

        public Criteria andPdimageEqualTo(String value) {
            addCriterion("pdimage =", value, "pdimage");
            return (Criteria) this;
        }

        public Criteria andPdimageNotEqualTo(String value) {
            addCriterion("pdimage <>", value, "pdimage");
            return (Criteria) this;
        }

        public Criteria andPdimageGreaterThan(String value) {
            addCriterion("pdimage >", value, "pdimage");
            return (Criteria) this;
        }

        public Criteria andPdimageGreaterThanOrEqualTo(String value) {
            addCriterion("pdimage >=", value, "pdimage");
            return (Criteria) this;
        }

        public Criteria andPdimageLessThan(String value) {
            addCriterion("pdimage <", value, "pdimage");
            return (Criteria) this;
        }

        public Criteria andPdimageLessThanOrEqualTo(String value) {
            addCriterion("pdimage <=", value, "pdimage");
            return (Criteria) this;
        }

        public Criteria andPdimageLike(String value) {
            addCriterion("pdimage like", value, "pdimage");
            return (Criteria) this;
        }

        public Criteria andPdimageNotLike(String value) {
            addCriterion("pdimage not like", value, "pdimage");
            return (Criteria) this;
        }

        public Criteria andPdimageIn(List<String> values) {
            addCriterion("pdimage in", values, "pdimage");
            return (Criteria) this;
        }

        public Criteria andPdimageNotIn(List<String> values) {
            addCriterion("pdimage not in", values, "pdimage");
            return (Criteria) this;
        }

        public Criteria andPdimageBetween(String value1, String value2) {
            addCriterion("pdimage between", value1, value2, "pdimage");
            return (Criteria) this;
        }

        public Criteria andPdimageNotBetween(String value1, String value2) {
            addCriterion("pdimage not between", value1, value2, "pdimage");
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