package com.springboot.shiroproject.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.shiroproject.entity.Permission;
import com.springboot.shiroproject.mapper.PermissionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 蒲雪冰
 * @since 2019-12-23
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IService<Permission> {

}
