package com.mhc.validator_test.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mhc.validator_test.json.IntegerDeserialize;
import com.mhc.validator_test.validator.AssertInteger;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
public class User {

    @Size(min = 1, max = 10, message = "姓名长度必须为1-10")
    @Pattern(regexp = "^[a-zA-Z0-9_\u4e00-\u9fa5]*$", message = "名字只能是数字, 字母, 汉字, 下划线")
    @Pattern(regexp = "^[^0-9]+.*$", message = "名字不能以数字开头")
    private String name;

//    @NotEmpty://CharSequence, Collection, Map 和 Array 对象不能是 null 并且相关对象的 size 大于 0。
//    @NotBlank://String 不是 null 且去除两端空白字符后的长度（trimmed length）大于 0。
    // 和notNull的区别是notNull允许空字符串
    @NotEmpty
    private String firstName;

    @Min(value = 10, message = "年龄最小为10")
    @Max(value = 100, message = "年龄最大为100")
    @JsonDeserialize(using = IntegerDeserialize.class)
    private Integer age;

//    @Future(message = "出生日期必须是将来的时间")
//    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
//    private Date birth;

    @Valid
    private List<Sub> subs;

    @AssertInteger(name = "haha")
    private String value;

}
