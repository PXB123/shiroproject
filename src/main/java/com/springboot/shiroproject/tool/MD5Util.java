/**
 * <h3>shiroproject</h3>
 * <p></p>
 *
 * @author : 蒲雪冰
 * @date : 2020-01-08 20:25
 **/
package com.springboot.shiroproject.tool;

import com.springboot.shiroproject.entity.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Util {
    public static void md5(User user){
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String algorithmName = "md5";
        String encodedPassword = new SimpleHash(algorithmName,user.getPassword(),salt,times).toString();
        user.setPassword(encodedPassword);
        user.setSalt(salt);
    }
}
