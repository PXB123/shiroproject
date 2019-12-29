///**
// * <h3>shiroproject</h3>
// * <p>shiro测试类</p>
// *
// * @author : 蒲雪冰
// * @date : 2019-12-20 10:05
// **/
//package com.springboot.shiroproject;
//
//import com.springboot.shiroproject.tool.MyRealm;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.config.IniSecurityManagerFactory;
//import org.apache.shiro.crypto.hash.Md5Hash;
//import org.apache.shiro.mgt.DefaultSecurityManager;
//import org.apache.shiro.subject.Subject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class TestShiro {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private PermissionService permissionService;
//
//    @Test
//    void testShiro() {
//        User user = new User();
//        user.setName("张三");
//        user.setPassword("12345");
//
//        //1、创建SecurityManager工厂
//        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        //2、从工厂中得到SecurityManager
//        DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();
//
//        MyRealm realm = new MyRealm();
//        securityManager.setRealm(realm);
//
//        //3、把当前SecurityManager绑定到当前线程
//        SecurityUtils.setSecurityManager(securityManager);
////        //4、取出当前Subject
//        Subject subject = SecurityUtils.getSubject();
//        //5、封装用户名和密码
//        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
//        //6、进行认证
//        try {
//            subject.login(token);
//            System.out.println("认证成功");
//        } catch (AuthenticationException e) {
//            System.out.println("用户名或密码不正确");
//        }
//
//    }
//    @Test
//    public void a(){
//        Permission permission = permissionService.getById(2);
//        System.out.println(permission);
//    }
//    @Test void b(){
//        String source = "12345";
//        Md5Hash hash = new Md5Hash(source);
//        System.out.println("加密一次："+hash.toString());
//        Md5Hash hash1 = new Md5Hash(source,"abc",2);
//        System.out.println(hash1.toString());
//    }
//
//
//}