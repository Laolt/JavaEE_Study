package org.example.controller;

import org.example.exception.BusinessException;
import org.example.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//服务器异常处理类(异常处理器)
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)//指定拦截异常的种类，此处为拦截全部异常
    public Result doException(Exception e){
        e.printStackTrace();//其他逻辑
        return new Result(e.hashCode(),null,"服务器异常");
    }
    @ExceptionHandler(SystemException.class)//指定拦截异常的种类，此处为拦截系统异常
    public Result doSystemException(SystemException e){
        e.printStackTrace();//其他逻辑
        return new Result(e.getCode(),null,"系统很忙，请等一下好嘛？");
    }
    @ExceptionHandler(BusinessException.class)//指定拦截异常的种类，此处为拦截业务异常
    public Result doBusinessException(BusinessException e){
        e.printStackTrace();//其他逻辑
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,e.getMessage());
    }
}
