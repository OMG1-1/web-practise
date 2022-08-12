package com.kzy.controller;

import com.kzy.common.CommonConstant;
import com.kzy.exception.BusinessException;
import com.kzy.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kobe
 * @date 2022/8/12
 * @time 21:05
 * @note ……
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        return new Result(ex.getCode(),ex.getMessage());
    }

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        //记录日志(错误堆栈)
        //发送邮件给开发人员
        //发送短信给运维人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
        //记录日志(错误堆栈)
        //发送邮件给开发人员
        return new Result(CommonConstant.SYSTEM_UNKNOWN_ERR,ex.getMessage());
    }
}
