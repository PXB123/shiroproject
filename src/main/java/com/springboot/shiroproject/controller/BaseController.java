package com.springboot.shiroproject.controller;

import com.springboot.shiroproject.error.BusinessException;
import com.springboot.shiroproject.error.EnumBusinessError;
import com.springboot.shiroproject.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {

    public static final String CONTENT_TYPE_FORMED = "application/x-www-from-urlencoded";
    //定义exceptionhandler解决未被controller层吸收的exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex){
        Map<String,Object> responseData = new HashMap<>();
        if(ex instanceof BusinessException){
            BusinessException businessException = (BusinessException)ex;
            responseData.put("errCode",businessException.getErrCode());
            responseData.put("errMsg",businessException.getErrMsg());
        } else{
            System.out.println(ex);
            responseData.put("errCode", EnumBusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg",EnumBusinessError.UNKNOWN_ERROR.getErrMsg());
        }
        return  CommonReturnType.create(responseData,"fail");
    }
}
