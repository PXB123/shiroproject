package com.springboot.shiroproject.service.impl;

import com.springboot.shiroproject.entity.User;
import com.springboot.shiroproject.mapper.UserMapper;
import com.springboot.shiroproject.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 蒲雪冰
 * @since 2019-12-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
