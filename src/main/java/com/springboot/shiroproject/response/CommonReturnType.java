package com.springboot.shiroproject.response;

import lombok.Data;

@Data
public class CommonReturnType {
    //表面对应请求的返回处理结果 "success"或"fail"
    private Integer code;
    private String msg;
    //若status=success则data内返回前端需要的json数据
    //若status=fail，则data内使用通用的错误码格式
    private Object data;

    //定义一个通用的创建方法
    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,0,"处理成功");
    }

    public static CommonReturnType create(Object result,Integer code,String msg){
       CommonReturnType type = new CommonReturnType();
       type.setCode(code);
       type.setMsg(msg);
       type.setData(result);
       return type;
    }

}
