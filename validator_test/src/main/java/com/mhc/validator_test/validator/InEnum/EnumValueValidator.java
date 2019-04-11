package com.mhc.validator_test.validator.InEnum;

import com.mhc.validator_test.util.ReflectUtil;
import com.mhc.validator_test.validator.assertInteger.AssertInteger;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.util.Strings;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EnumValueValidator implements ConstraintValidator<EnumValue, Object> {

    private Class<? extends Enum<?>> enumClass;
    private String fieldName;
    private String friendlyName;

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
        String msg;
        Method read = ReflectUtil.getReadMethod(enumClass, fieldName);
        if(read == null) {
            msg = "不能获取类" + enumClass.getName() + "中属性" + fieldName + "的read方法";
        } else {
            Object[] objects = enumClass.getEnumConstants();
            Object[] valids = new Object[objects.length];

            try {
                for(int i=0; i<objects.length; i++){
                    valids[i] = read.invoke(objects[i]);
                    if(s.equals(valids[i])){
                        return true;
                    }
                }
                msg = "请输入有效的" + friendlyName + "(" + StringUtils.join(valids, ",") + ")";
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                msg = e.getMessage();
            }

        }
        constraintValidatorContext.disableDefaultConstraintViolation();//禁用默认的message的值
        constraintValidatorContext
                .buildConstraintViolationWithTemplate(msg).addConstraintViolation();
        return false;
    }

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        fieldName = constraintAnnotation.fieldName();
        enumClass = constraintAnnotation.enumClass();
        friendlyName = constraintAnnotation.friendlyName();
    }
}
