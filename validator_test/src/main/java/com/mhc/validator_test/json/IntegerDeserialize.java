package com.mhc.validator_test.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.mhc.validator_test.exceptions.ConvertIntegerException;

import java.io.IOException;

public class IntegerDeserialize extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        System.out.println();
        try {
            Integer.valueOf(jsonParser.getValueAsString());
        } catch (NumberFormatException e) {
            throw new ConvertIntegerException(jsonParser.getCurrentName() + "必须是整数");
        }
        return jsonParser.getIntValue();
    }

}
