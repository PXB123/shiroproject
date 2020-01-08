package com.springboot.shiroproject.controller;


import com.springboot.shiroproject.entity.User;
import com.springboot.shiroproject.error.BusinessException;
import com.springboot.shiroproject.error.EnumBusinessError;
import com.springboot.shiroproject.response.CommonReturnType;
import com.springboot.shiroproject.service.UserService;
import com.springboot.shiroproject.tool.RandomValidateCodeUtil;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 蒲雪冰
 * @since 2019-12-29
 * public CommonReturnType doLogin(String userName,String password) {
 *         Object principal = null;
 *         Subject subject = SecurityUtils.getSubject();
 *         try {
 *             subject.login(new UsernamePasswordToken(userName,password));
 */
@RestController
@Slf4j
@Api(value = "用户管理",tags = "用户管理")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;
    @ApiOperation(value = "用户登录", notes="用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userName",value="用户名",example="张三"),
            @ApiImplicitParam(name="password",value="密码",example="12345")})
    @GetMapping("/doLogin")
    public CommonReturnType doLogin(  String userName, String password) throws BusinessException {
        Object principal = null;
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(userName, password));
           log.debug("登录成功!");
            principal = subject.getPrincipal();
        } catch (AuthenticationException e) {
            log.debug("登录失败!");
            throw new BusinessException(EnumBusinessError.USER_LOGIN_FAIL);
        }
        boolean user1 = subject.hasRole("user");
        boolean permitted = subject.isPermitted("user:query");
        return CommonReturnType.create(principal);
    }

    @ApiOperation(value = "查询所有用户", notes="查询所有用户")
    @GetMapping("/userList")
    public CommonReturnType getUserList(){
        List<User> list = userService.list();
        return CommonReturnType.create(list);
    }

    /**
     * 生成验证码
     */
    @ApiOperation(value = "获取图片验证码", notes="获取图片验证码")
    @GetMapping(value = "/getVerify")
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
