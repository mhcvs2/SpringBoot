package com.mhc.validator_test.enums;

import lombok.Getter;

/**
 * create by liuzx on 2018/9/11
 **/
@Getter
public enum ResponseCodeEnum {
    SUCCESS(200,"success"),@Deprecated  DATA_EMPTY(200,"data is empty"),NO_LOGIN(300,"登录状态失效，请重新登录！"),ERROR(500,
            "error"),PARAM_ERROR(600,"param error");
    private int code;
    private String msg;
    ResponseCodeEnum(int code, String msg){
        this.code = code;
        this.msg =msg;
    }
}
