package com.boot.bootlanuch.exception;

import com.boot.bootlanuch.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Map;

/**
 * @author admin
 */
@Component
@ControllerAdvice
@Slf4j
public class GlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(selectedContentType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)){
            response.setStatusCode(HttpStatus.valueOf((Integer) ((RestResponse) body).get("code")));
            log.info("StatusCode:"+((RestResponse) body).get("code"));
            return body;
        }
        return null;
    }
}
