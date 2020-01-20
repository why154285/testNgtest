package com.orientsec.test.agw.model.csv;

import com.opencsv.bean.CsvBindByName;

public class DealsQueryModel {

    @CsvBindByName(column = "custId", required = true)
    private String custId;

    @CsvBindByName(column = "fundAccountId", required = true)
    private String fundAccountId;

    @CsvBindByName(column = "accountId", required = true)
    private String accountId;

    @CsvBindByName(column = "securityId", required = true)
    private String securityId;

    @CsvBindByName(column = "clientFeatureCode", required = true)
    private String clientFeatureCode;

    @CsvBindByName(column = "market", required = true)
    private String market;

    @CsvBindByName(column = "businessType", required = true)
    private String businessType;

    @CsvBindByName(column = "queryIndex", required = true)
    private Integer queryIndex;

    @CsvBindByName(column = "returnNum", required = true)
    private Integer returnNum;

    @CsvBindByName(column = "returnOrder", required = true)
    private Integer returnOrder;

    @CsvBindByName(column = "userInfo", required = true)
    private String userInfo;

    @CsvBindByName(column = "password", required = true)
    private String password;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getFundAccountId() {
        return fundAccountId;
    }

    public void setFundAccountId(String fundAccountId) {
        this.fundAccountId = fundAccountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public String getClientFeatureCode() {
        return clientFeatureCode;
    }

    public void setClientFeatureCode(String clientFeatureCode) {
        this.clientFeatureCode = clientFeatureCode;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Integer getQueryIndex() {
        return queryIndex;
    }

    public void setQueryIndex(Integer queryIndex) {
        this.queryIndex = queryIndex;
    }

    public Integer getReturnNum() {
        return returnNum;
    }

    public void setReturnNum(Integer returnNum) {
        this.returnNum = returnNum;
    }

    public Integer getReturnOrder() {
        return returnOrder;
    }

    public void setReturnOrder(Integer returnOrder) {
        this.returnOrder = returnOrder;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
