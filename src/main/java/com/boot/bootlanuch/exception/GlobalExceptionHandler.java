package com.boot.bootlanuch.exception;

import com.boot.bootlanuch.response.ResponseBase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public  ResponseBase error(String message) {
        ResponseBase responseBase = ResponseBase.builder()
                .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR))
                .isok(false)
                .message(message)
                .build();
        return responseBase;
    }

}
