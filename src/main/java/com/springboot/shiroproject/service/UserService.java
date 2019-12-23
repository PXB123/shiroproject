package com.springboot.shiroproject.service;

import com.springboot.shiroproject.entity.User;
import com.springboot.shiroproject.entity.UserRole;

import java.util.List;

public interface UserService {
    User selectPasswordByName(String userName);

    List<UserRole> listRoles(String uid);

}
