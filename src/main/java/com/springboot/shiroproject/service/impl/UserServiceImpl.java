/**
 * <h3>shiroproject</h3>
 * <p></p>
 *
 * @author : 蒲雪冰
 * @date : 2019-12-21 08:38
 **/
package com.springboot.shiroproject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.shiroproject.entity.UserRole;
import com.springboot.shiroproject.mapper.UserMapper;
import com.springboot.shiroproject.entity.User;
import com.springboot.shiroproject.mapper.UserRoleMapper;
import com.springboot.shiroproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User selectPasswordByName(String userName){
       return userMapper.selectPasswordByName(userName);
    }

    @Override
    public List<UserRole> listRoles(String uid){
        return userRoleMapper.listRoles(uid);
    }


}
