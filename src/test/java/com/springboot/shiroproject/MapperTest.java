///**
// * <h3>shiroproject</h3>
// * <p></p>
// *
// * @author : 蒲雪冰
// * @date : 2019-12-28 09:48
// **/
//package com.springboot.shiroproject;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.*;
//
//@SpringBootTest
//public class MapperTest {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    /**
//     * 查询
//     */
//    @Test
//    public void queyUser(){
//        User user = userMapper.selectById(3);
//        System.out.println(user);
//
//    }
//
//    /**
//     * 增加用户
//     */
//    @Test
//    public void addUser(){
//        User user = new User();
//        user.setName("李四");
//        user.setPassword("12345aaa");
//        user.setEmail("2679862469@qq.com");
//        user.setCreate_time(Calendar.getInstance().getTime());
//        user.setLast_login_time(Calendar.getInstance().getTime());
//        userMapper.insert(user);
//    }
//
//    /**
//     * 修改
//     */
//    @Test
//    public void updateUser(){
//        User user = userMapper.selectById(3);
//        user.setName("李四12");
//        int i = userMapper.updateById(user);
//        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.between("id",3,4);
//
//        userMapper.update(user,updateWrapper);
//        System.out.println(i);
//    }
//    /**
//     * 删除
//     */
//    @Test
//    public void deleteUser(){
//        List <Integer> userList = Arrays.asList(3,4);
//        userMapper.deleteBatchIds(userList);
//
//    }
//
//    /**
//     * map查询
//     */
//    @Test
//    public void selectMapUser(){
//        Map<String,Object> userMap = new HashMap<>();
//        userMap.put("name","张三");
//        List<User> users = userMapper.selectByMap(userMap);
//        System.out.println(users);
//    }
//    /**
//     * 查询一个
//     */
//    @Test
//    public void query1(){
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id",5);
//        User user = userMapper.selectOne(queryWrapper);
//        System.out.println(user);
//    }
//    /**
//     * 查询集合
//     */
//    @Test
//    public void queryListUser(){
//        List<Integer> integers = Arrays.asList(5, 6);
//        List<User> users = userMapper.selectBatchIds(integers);
//        for (User user:users) {
//            System.out.println(user);
//        }
//    }
//}
