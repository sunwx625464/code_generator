package com.robert.codegenerator.common.exceptions;

import lombok.Getter;

/**
 * @author sunweixin
 * @date 2024/7/24
 * @description
 */
public class BusinessException extends RuntimeException{

    @Getter
    private final int code;

    private final String message;

    public BusinessException(int code,String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }

}
