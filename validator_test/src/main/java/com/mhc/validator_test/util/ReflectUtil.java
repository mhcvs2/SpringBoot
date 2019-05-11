package com.mhc.validator_test.util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReflectUtil {

    public static Map<String, PropertyDescriptor> getPropertyDescriptorMap(Class<?> clz){
        Map<String, PropertyDescriptor> res = new HashMap<>();
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clz).getPropertyDescriptors();
            for(PropertyDescriptor propertyDescriptor: propertyDescriptors) {
                if(Objects.equals(propertyDescriptor.getName(), "class")){
                    continue;
                }
                res.put(propertyDescriptor.getName(), propertyDescriptor);
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static PropertyDescriptor getPropertyDescriptorByName(Class<?> clz, String name) {
        Map<String, PropertyDescriptor> map = getPropertyDescriptorMap(clz);
        return map.get(name);
    }

    public static Method getReadMethod(Class<?> clz, String name){
        PropertyDescriptor propertyDescriptor = getPropertyDescriptorByName(clz, name);
        return propertyDescriptor == null ? null : propertyDescriptor.getReadMethod();
    }

    public static Method getWriteMethod(Class<?> clz, String name){
        PropertyDescriptor propertyDescriptor = getPropertyDescriptorByName(clz, name);
        return propertyDescriptor == null ? null : propertyDescriptor.getWriteMethod();
    }

}
