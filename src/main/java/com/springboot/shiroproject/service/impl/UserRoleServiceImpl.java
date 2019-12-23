package com.springboot.shiroproject.service.impl;

import com.springboot.shiroproject.entity.UserRole;
import com.springboot.shiroproject.mapper.UserRoleMapper;
import com.springboot.shiroproject.service.UserRoleService;
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
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
