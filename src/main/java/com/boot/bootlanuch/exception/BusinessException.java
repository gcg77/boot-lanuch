package com.boot.bootlanuch.exception;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class BusinessException extends Exception  {
    private String code;
    private String message;
    public BusinessException(String message){
       this.message=message;
   }
}
