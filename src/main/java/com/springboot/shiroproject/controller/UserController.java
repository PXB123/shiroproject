/**
 * <h3>shiroproject</h3>
 * <p></p>
 *
 * @author : 蒲雪冰
 * @date : 2019-12-21 08:39
 **/
package com.springboot.shiroproject.controller;

import com.springboot.shiroproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserController {
    @Autowired
    private UserService userService;
}
