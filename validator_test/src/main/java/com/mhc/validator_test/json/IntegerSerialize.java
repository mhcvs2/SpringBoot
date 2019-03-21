package com.mhc.validator_test.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.Objects;

@JsonComponent
public class IntegerSerialize extends JsonSerializer<Integer> {
//        implements ContextualSerializer {


    @Override
    public void serialize(Integer integer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        System.out.println("IntegerSerialize handle--------------: " + integer);
        jsonGenerator.writeNumber(integer);
    }

//    @Override
//    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
//        if(beanProperty != null) {
//            if(Objects.equals(beanProperty.getType().getRawClass(), Integer.class)){
////                SensitiveInfo sensitiveInfo = beanProperty.getAnnotation(SensitiveInfo.class);  //可以读取注解
////                if (sensitiveInfo == null) {
////                    sensitiveInfo = beanProperty.getContextAnnotation(SensitiveInfo.class);
////                }
////                if (sensitiveInfo != null) { // 如果能得到注解，就将注解的 value 传入 SensitiveInfoSerialize
////
////                    return new IntegerSerialize(sensitiveInfo.value());
////                }
//            }
//        }
//        return null;
//    }
}
