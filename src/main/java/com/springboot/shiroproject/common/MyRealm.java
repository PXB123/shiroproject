/**
 * <h3>shiroproject</h3>
 * <p>shiro工具类</p>
 *
 * @author : 蒲雪冰
 * @date : 2019-12-20 11:48
 **/
package com.springboot.shiroproject.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.shiroproject.entity.*;
import com.springboot.shiroproject.service.*;
import com.springboot.shiroproject.service.model.UserModel;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //能进入到这里，表示账号已经通过验证了
        UserModel userModel =(UserModel) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
       if(userModel.getUser().getType() == 1){
           info.addStringPermission("*:*");
       }else{
           List<String> roles = userModel.getRoles();
           List<String> permissions = userModel.getPermissions();
           if (null != roles){
               info.addRoles(roles);
           }
           if (null != permissions){
               info.addStringPermissions(permissions);
           }
       }


        return info;
    }

    @Override
    /**
     * 完成认证
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        List<String> roles = new ArrayList<>();
        List<String> permissions = new ArrayList<>();
        //获取账号密码
        UsernamePasswordToken t = (UsernamePasswordToken) token;
        String userName= token.getPrincipal().toString();
        String password= new String( t.getPassword());
        //String password Arrays.toString((char[] )t.getPassword());
        //获取数据库中的密码
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name",userName);
        User user = userService.getOne(wrapper);

        //如果为空就是账号不存在，如果不相同就是密码错误，但是都抛出AuthenticationException，而不是抛出具体错误原因，免得给破解者提供帮助信息
        if(null==user){
            throw new AuthenticationException();
        }

        QueryWrapper<UserRole> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("uid",user.getId());
        List<UserRole> userRoles = userRoleService.list(wrapper1);
        for (UserRole userRole: userRoles) {
            Role role = roleService.getById(userRole.getRid());
            roles.add(role.getName());
            QueryWrapper<RoleMenu> wrapper2 = new QueryWrapper<>();
            wrapper2.eq("rid",userRole.getRid());
            List<RoleMenu> list = roleMenuService.list(wrapper2);
            for (RoleMenu roleMenu: list) {
                Menu menu = menuService.getById(roleMenu.getMid());
                permissions.add(menu.getCode());
            }
        }
        UserModel userModel = new UserModel(user,roles,permissions);
        /**
         * 参数1：用户身份
         * 参数2：用户正确密码
         * 参数3：当前类名
         */
        SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(userModel,user.getPassword(),getName());
        /**
         * 参数1：传到doGetAuthorizationInfo的对象或subject.getProin...
         * 参数2：加密后的密码
         * 参数3：
         */
        ByteSource credentialaSalt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userModel,user.getPassword(),credentialaSalt,
                getName());
        return info;
    }

}

