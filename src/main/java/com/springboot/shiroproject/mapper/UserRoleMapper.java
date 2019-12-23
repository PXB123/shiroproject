package com.springboot.shiroproject.mapper;

import com.springboot.shiroproject.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 蒲雪冰
 * @since 2019-12-23
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<UserRole> listRoles(String uid);
}
