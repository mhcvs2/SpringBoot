package com.mhc.validator_test.common;

import com.mhc.validator_test.enums.ResponseCodeEnum;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static Pattern pattern = Pattern.compile("JSON parse error:(.*?);");


    /**
     * 用来处理bean validation异常
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseParam resolveConstraintViolationException(ConstraintViolationException ex){
        ResponseParam result = new ResponseParam(ResponseCodeEnum.ERROR);
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        if(!CollectionUtils.isEmpty(constraintViolations)){
            StringBuilder msgBuilder = new StringBuilder();
            for(ConstraintViolation constraintViolation :constraintViolations){
                msgBuilder.append(constraintViolation.getMessage()).append(",");
            }
            String errorMessage = msgBuilder.toString();
            if(errorMessage.length()>1){
                errorMessage = errorMessage.substring(0,errorMessage.length()-1);
            }
            result.setResult(errorMessage);
            return result;
        }
        result.setResult(ex.getMessage());
        return result;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseParam resolveMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        ResponseParam result = new ResponseParam(ResponseCodeEnum.ERROR);
        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
        if(!CollectionUtils.isEmpty(objectErrors)) {
            StringBuilder msgBuilder = new StringBuilder();
            for (ObjectError objectError : objectErrors) {
                msgBuilder.append(objectError.getDefaultMessage()).append(",");
            }
            String errorMessage = msgBuilder.toString();
            if (errorMessage.length() > 1) {
                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
            }
            result.setResult(errorMessage);
            return result;
        }
        result.setResult(ex.getMessage());
        return result;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseParam resolveConvertIntegerException(HttpMessageNotReadableException ex){
        String message = ex.getMessage();
        if(message != null && !message.equals("")){
            Matcher m = pattern.matcher(message);
            if(m.find()){
                message = m.group(1);
            }
        }
        return new ResponseParam(ResponseCodeEnum.ERROR.getCode(), message);
    }
}
