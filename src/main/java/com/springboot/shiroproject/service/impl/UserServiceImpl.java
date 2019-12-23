/**
 * <h3>shiroproject</h3>
 * <p></p>
 *
 * @author : 蒲雪冰
 * @date : 2019-12-21 08:38
 **/
package com.springboot.shiroproject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.shiroproject.dao.UserInfoDao;
import com.springboot.shiroproject.entity.User;
import com.springboot.shiroproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl extends ServiceImpl<UserInfoDao, User> implements UserService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public String selectPasswordByName(String userName){
       return userInfoDao.selectPasswordByName(userName);
    }

    @Override
    public List<String> listPermissions(String userName) {
        List<String> permissions = userInfoDao.listPermissions(userName);
        return permissions;
    }

    @Override
    public List<String> listRoles(String userName) {
        List<String> roles = userInfoDao.listRoles(userName);
        return roles;
    }
}
