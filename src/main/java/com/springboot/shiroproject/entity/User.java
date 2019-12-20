/**
 * <h3>shiroproject</h3>
 * <p>用户类</p>
 *
 * @author : 蒲雪冰
 * @date : 2019-12-20 10:04
 **/
package com.springboot.shiroproject.entity;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String name;
    private String password;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
