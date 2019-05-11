package com.mhc.validator_test.enums;

public enum ResultCode2 {
    CODE_5200(8200, "认证失败"),
    CODE_5201(8201, "用户不存在"),
    CODE_5202(8202, "Token验证失败"),
    CODE_5203(8203, "Token刷新失败");
    private int code;
    private String name;

    private ResultCode2(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
