package com.javaclimb.itmusic.exception;


import com.javaclimb.itmusic.utils.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.javaclimb.itmusic.utils.enums.HttpCodeEnum.RC101;

@ControllerAdvice
public class GlobalExceptionHandler {

    /*
    *运行时异常
    * */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult exceptionHandler(CustomException e){


        return  ResponseResult.fail(e.getCode(),e.getMessage());
    }
}
