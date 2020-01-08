package com.springboot.shiroproject.controller;


import com.springboot.shiroproject.entity.Role;
import com.springboot.shiroproject.response.CommonReturnType;
import com.springboot.shiroproject.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 蒲雪冰
 * @since 2019-12-29
 */
@RestController
@RequestMapping("/role")
@Slf4j
@Api(value = "角色管理",tags = "角色管理")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取所有角色" ,notes="获取所有角色")
    @GetMapping("/list")
    public CommonReturnType roleList(){
        List<Role> roles = roleService.list();
        return CommonReturnType.create(roles);
    }
}
