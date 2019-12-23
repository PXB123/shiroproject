/**
 * <h3>shiroproject</h3>
 * <p>用户表操作dao</p>
 *
 * @author : 蒲雪冰
 * @date : 2019-12-20 14:48
 **/
package com.springboot.shiroproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.shiroproject.entity.User;

import java.util.List;

public interface UserInfoDao extends BaseMapper<User> {
    String selectPasswordByName(String userName);

    List<String> listPermissions(String userName);

    List<String> listRoles(String userName);
}
