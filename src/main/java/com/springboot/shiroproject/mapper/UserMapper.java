/**
 * <h3>shiroproject</h3>
 * <p>用户表操作dao</p>
 *
 * @author : 蒲雪冰
 * @date : 2019-12-20 14:48
 **/
package com.springboot.shiroproject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.shiroproject.entity.User;

public interface UserMapper extends BaseMapper<User> {
    User selectPasswordByName(String userName);



}
