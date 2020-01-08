package com.springboot.shiroproject.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("user")
@ApiModel(value = "用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户名")
    private String name;

    /**
     * 邮箱|登录帐号
     */
    @ApiModelProperty(value = "登录账号")
    private String email;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 盐值
     */
    @ApiModelProperty(value = "盐值")
    private String salt;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间")
    @TableField("last_login_time")
    private Date lastLoginTime;

    /**
     * 1:有效，0:禁止登录
     */
    @ApiModelProperty(value = "1:有效，0:禁止登录")
    private Integer status;

    /**
     * 1:超级管理员，0：普通用户
     */
    @ApiModelProperty(value = "1:超级管理员，0：普通用户")
    private Integer type;


}
