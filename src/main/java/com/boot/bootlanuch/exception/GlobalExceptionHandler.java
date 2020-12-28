package com.boot.bootlanuch.exception;

import com.boot.bootlanuch.response.ResponseBase;
import com.boot.bootlanuch.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public RestResponse globalBusinessException(BusinessException e) {
        log.error(e.getMessage(),e);
        RestResponse restResponse=new RestResponse();
        restResponse.put("code",e.getCode());
        restResponse.put("message",e.getMessage());
        return restResponse;
    }
    @ExceptionHandler(Exception.class)
    public RestResponse globalException(Exception e) {
        log.error(e.getMessage());
        return RestResponse.error();
    }
    @ExceptionHandler(RuntimeException.class)
    public RestResponse globalRuntimeException(RuntimeException e) {
        log.error(e.getMessage(),e);
        return RestResponse.error("系统未知异常，请联系管理员！");
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestResponse globalValidException(MethodArgumentNotValidException e){
        FieldError error=e.getBindingResult().getFieldError();
        return RestResponse.error(error.getDefaultMessage());
    }

}
