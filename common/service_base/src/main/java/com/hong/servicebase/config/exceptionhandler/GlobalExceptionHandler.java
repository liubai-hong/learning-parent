package com.hong.servicebase.config.exceptionhandler;

import com.hong.commonutils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exceptionHandler(){
        return Result.error().message("统一异常处理");
    }
}
