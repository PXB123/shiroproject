/**
 * <h3>shiroproject</h3>
 * <p></p>
 *
 * @author : 蒲雪冰
 * @date : 2019-12-28 17:01
 **/
package com.springboot.shiroproject.service.model;

import com.springboot.shiroproject.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserModel {
    private User user;
    private List<String> roles;
    private List<String> permissions;
}
