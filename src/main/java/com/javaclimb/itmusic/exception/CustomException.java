package com.javaclimb.itmusic.exception;

import lombok.Getter;

@Getter

public class CustomException extends RuntimeException{
    private Integer code;

    public  CustomException(Integer code, String msg){
        super(msg);
        this.code=code;
    }


}
