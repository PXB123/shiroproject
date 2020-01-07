package com.springboot.shiroproject.controller;


import com.springboot.shiroproject.entity.User;
import com.springboot.shiroproject.response.CommonReturnType;
import com.springboot.shiroproject.tool.RandomValidateCodeUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 蒲雪冰
 * @since 2019-12-29
 */
@RestController
public class UserController extends BaseController{
    @ApiOperation(value = "登录", notes="登录")
    @GetMapping("/doLogin")
    public CommonReturnType doLogin() {
        Object principal = null;
        User user = new User();
        user.setName("张三");
        user.setPassword("12345");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(user.getName(), user.getPassword()));
            System.out.println("登录成功!");
            principal = subject.getPrincipal();
            System.out.println(principal);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登录失败!");
        }
        boolean user1 = subject.hasRole("user");
        boolean permitted = subject.isPermitted("user:query");
        return CommonReturnType.create(principal);
    }

    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {

        }
    }

}
