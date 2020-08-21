package com.sinovate.ngrms.gcbscsvr.das.support.Utils;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigInteger;
import java.util.List;

/**
 * @author liu.heng
 * @date 2015/9/4 17:40
 * @desc
 * @see
 */
public class MqlContext {

    /** 执行的sql */
    private StringBuilder mql;

    /** 主键名称 */
    private String primaryKey;

    /** 主键值 */
    private BigInteger pkValue;

    /** 参数，对应sql中的?号 */
    private List<Object> params;

    public MqlContext(StringBuilder mql, String primaryKey, BigInteger pkValue, List<Object> params) {
        this.mql = mql;
        this.primaryKey = primaryKey;
        this.pkValue = pkValue;
        this.params = params;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }

    public StringBuilder getMql() {
        return mql;
    }

    public void setMql(StringBuilder mql) {
        this.mql = mql;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public BigInteger getPkValue() {
        return pkValue;
    }

    public void setPkValue(BigInteger pkValue) {
        this.pkValue = pkValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("mql", mql)
                .append("primaryKey", primaryKey)
                .append("pkValue", pkValue)
                .append("params", params)
                .toString();
    }
}
