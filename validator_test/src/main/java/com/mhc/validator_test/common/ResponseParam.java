package com.mhc.validator_test.common;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mhc.validator_test.enums.ResponseCodeEnum;
import lombok.Data;


@Data
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class ResponseParam {
    private int status = ResponseCodeEnum.SUCCESS.getCode();
    private String message = ResponseCodeEnum.SUCCESS.getMsg();
    private Object result;

    public ResponseParam() {
    }

    public ResponseParam(String message) {
        this.message = message;
    }

    public ResponseParam(int status, String message) {
        this.status = status;
        this.message = message;
    }
    public ResponseParam(String message, Object result) {
        this.message = message;
        this.result = result;
    }
    public ResponseParam(Object result) {
        this.result = result;
    }

    public ResponseParam(ResponseCodeEnum codeEnum){
        this.status = codeEnum.getCode();
        this.message = codeEnum.getMsg();
    }
    public String toJSONString(){
       return JSON.toJSONString(this);
    }
}
