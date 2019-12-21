/**
 * <h3>shiroproject</h3>
 * <p></p>
 *
 * @author : 蒲雪冰
 * @date : 2019-12-21 08:38
 **/
package com.springboot.shiroproject.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.shiroproject.dao.UserInfoDao;
import com.springboot.shiroproject.entity.User;
import com.springboot.shiroproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl extends ServiceImpl<UserInfoDao, User> implements UserService {
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public String selectPasswordByName(String userName){
       return userInfoDao.selectPasswordByName(userName);
    }
}
