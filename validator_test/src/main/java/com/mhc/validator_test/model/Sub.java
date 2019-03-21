package com.mhc.validator_test.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Sub {

    @NotBlank(message = "f1 不能为空")
    private String f1;

}
