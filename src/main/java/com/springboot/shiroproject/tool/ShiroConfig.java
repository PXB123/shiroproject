/**
 * <h3>shiroproject</h3>
 * <p>Shiro配置</p>
 *
 * @author : 蒲雪冰
 * @date : 2019-12-28 15:25
 **/
package com.springboot.shiroproject.tool;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 描述：
 *
 * @author pxb
 * @create 2019-01-27-13:38
 */
@Configuration
public class ShiroConfig {
    @Bean
    MyRealm myRealm() {
        MyRealm myRealm = new MyRealm();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(2);
        //加入凭证匹配器
        myRealm.setCredentialsMatcher(credentialsMatcher);
        return myRealm;
    }

    @Bean
    SecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm());
        return manager;
    }

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        //登录页面
        bean.setLoginUrl("/login");
        //登录成功页面
        bean.setSuccessUrl("/index");
        //未授权页面
        bean.setUnauthorizedUrl("/unauthorizedurl");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/css/*", "anon");
        map.put("/js/*", "anon");
        map.put("/img/*", "anon");
        map.put("/html/*", "anon");
        map.put("/swagger-ui.html", "anon");
        map.put("/swagger-resources/**", "anon");
        map.put("/webjars/**", "anon");
        map.put("/v2/**", "anon");
        map.put("/doLogin", "anon");
        map.put("/getVerify", "anon");

        map.put("/**", "authc");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }
}