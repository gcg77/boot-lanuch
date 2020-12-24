package com.boot.bootlanuch.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author Administrator
 */
@Data
public class BusinessException extends RuntimeException  {
    private static final long serialVersionUID=1L;
    private String message;
    private int code= HttpStatus.INTERNAL_SERVER_ERROR.value();
    public BusinessException(String message){
        super(message);
       this.message=message;
   }
   public BusinessException(String message,Throwable e){
        super(message,e);
        this.message=message;
   }
    public BusinessException(String message,int code){
        super(message);
        this.message=message;
        this.code=code;
    }
    public BusinessException(String message,int code,Throwable e){
        super(message,e);
        this.message=message;
        this.code=code;
    }
}
