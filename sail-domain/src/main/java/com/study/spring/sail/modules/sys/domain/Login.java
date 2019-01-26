package com.study.spring.sail.modules.sys.domain;

import com.study.spring.sail.common.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 系统信息 账户信息
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
public class Login extends BaseEntity {

    private static final long serialVersionUID = 1L;

    public static final String ADMIN = "admin";          // 超级账户标识

    private Long id;
    private String loginName;                               // 登录名
    private String password;                                // 密码
    private String loginStatus;                            // 登录状态
    private String loginType;                               // 账户类型 admin 超级账户
    private String phone;                                   // 手机号
    private String email;                                   // 邮箱
    private Long photoId;                                   // 头像id
    private Long userId;                                    // 用户id
    private String loginIp;                                 // 最后一次登录ip
    private Date loginDate;                                 // 最后一次登录时间

}
