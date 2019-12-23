package com.springboot.shiroproject.service.impl;

import com.springboot.shiroproject.entity.Role;
import com.springboot.shiroproject.mapper.RoleMapper;
import com.springboot.shiroproject.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
