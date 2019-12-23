package com.springboot.shiroproject.service;

import java.util.List;
import java.util.Set;

public interface UserService {
    String selectPasswordByName(String userName);

    List<String> listPermissions(String userName);

    List<String> listRoles(String userName);
}
