package com.mhc.validator_test.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.mhc.validator_test.exceptions.ConvertIntegerException;

import java.io.IOException;
import java.lang.reflect.Field;

public class IntegerDeserializeOld extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        try {
            Integer.valueOf(jsonParser.getValueAsString());
        } catch (NumberFormatException e) {
            Field[] fields = jsonParser.getCurrentValue().getClass().getDeclaredFields();
            String curName = jsonParser.currentName();
            JsonAlias annotation;
            String alias = null;
            for (Field field : fields) {
                if(field.getName().equals(curName)) {
                    annotation = field.getAnnotation(JsonAlias.class);
                    alias = annotation.name();
                    break;
                }
            }
            curName = alias != null? alias : curName;
            throw new ConvertIntegerException(curName + "必须是整数");
        }
        return jsonParser.getIntValue();
    }

}
