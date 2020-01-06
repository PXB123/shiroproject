package com.springboot.shiroproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 蒲雪冰
 * @since 2019-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父级菜单Id
     */
    private Integer pid;

    /**
     * 菜单标题
     */
    private String title;

    /**
     * 菜单链接
     */
    private String href;

    /**
     * 图标
     */
    private String icon;

    /**
     * 状态 1：启用，0：停用
     */
    private Integer avail;

    /**
     * 菜单代码
     */
    private String code;



}
