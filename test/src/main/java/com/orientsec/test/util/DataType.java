package com.orientsec.test.util;

public enum DataType {
    CSV("csv"),
    XML("xml"),
    JSON("json"),
    ;

    DataType(String code) {
        this.code = code;
    }

    DataType() {
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
