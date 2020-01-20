package com.orientsec.test.agw.model;

public class DealsQuery {

    private String custId;

    private String fundAccountId;

    private String accountId;

    private String securityId;

    private String clientFeatureCode;

    private String market;

    private String businessType;

    private Integer queryIndex;

    private Integer returnNum;

    private Integer returnOrder;

    private String userInfo;

    private String password;

    private long clientSeqId;

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

    public long getClientSeqId() {
        return clientSeqId;
    }

    public void setClientSeqId(long clientSeqId) {
        this.clientSeqId = clientSeqId;
    }
}
