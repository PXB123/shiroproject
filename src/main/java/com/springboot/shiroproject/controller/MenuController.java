package com.springboot.shiroproject.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 蒲雪冰
 * @since 2019-12-29
 */
@RestController
@RequestMapping("/menu")
@Slf4j
@Api(value = "权限管理",tags = "权限管理")
public class MenuController {

}
