package com.springboot.shiroproject.service.impl;

import com.springboot.shiroproject.entity.Menu;
import com.springboot.shiroproject.mapper.MenuMapper;
import com.springboot.shiroproject.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 蒲雪冰
 * @since 2019-12-29
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
