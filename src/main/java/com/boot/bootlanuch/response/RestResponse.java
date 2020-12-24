package com.boot.bootlanuch.response;


import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @author admin
 */
public class RestResponse extends HashMap<String,Object> {
    private static final long serialVersionUID=1L;
    public RestResponse(){
        put("code",400);
        put("message","success");
    }
    public static RestResponse error(){
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(),"未知异常，请联系管理员");
    }
    public static RestResponse error(String message){
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(),message);
    }
    public static RestResponse error(int code,String message){
        RestResponse restResponse=new RestResponse();
        restResponse.put("code",code);
        restResponse.put("message",message);
        return restResponse;
    }
    public static RestResponse success(String message){
        RestResponse restResponse=new RestResponse();
        restResponse.put("message",message);
        return restResponse;
    }
    public static RestResponse success(HashMap<String,Object>  map){
        RestResponse restResponse=new RestResponse();
        restResponse.putAll(map);
         return restResponse;
    }
    public static RestResponse success( ){
        return new RestResponse();
    }

    @Override
    public RestResponse put(String key, Object value) {
         super.put(key, value);
         return this;
    }
}
