package com.springboot.shiroproject.mapper;

import com.springboot.shiroproject.entity.RolePermission;
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
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    List<RolePermission> listPermissions(String rid);
}
