package com.study.spring.sail.modules.sys.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    // ------------------------------账户信息---------------------------------
    private Long loginId;                           // 账户id
    private String loginName;                      // 登录名
    private String password;                       // 密码
    private String loginStatus;                    // 登录状态
    private String loginType;                      // 账户类型
    private String phone;                           // 手机号
    private String email;                           // 邮箱
    private Long photoId;                           // 头像id
    private String loginIp;                         // 最后一次登录ip
    private Date loginDate;                         // 最后一次登录时间
    private Long loginCreateBy;                    // 账户创建人
    private Date loginCreateDate;                  // 账户创建时间
    private Long loginUpdateBy;                    // 账户最近一次修改人
    private Date loginUpdateDate;                  // 账户最近一次修改时间
    private String loginRemarks;                    // 账户备注
    private String loginDelFlag;                    // 账户删除标志

    // ------------------------------用户信息---------------------------------
    private Long userId;                             // 用户id
    private String userName;                         // 姓名
    private String sex;                               // 性别
    private String idCard;                           // 身份标识
    private String userType;                         // 用户类型
    private String userStatus;                       // 用户状态
    private Long orgId;                               // 机构id
    private Long areaId;                              // 地区id
    private String jsonInfo;                         // 其他信息json
    private Long userCreateBy;                       // 用户创建人
    private Date userCreateDate;                     // 用户创建时间
    private Long userUpdateBy;                       // 用户最近一次修改人
    private Date userUpdateDate;                     // 用户最近一次修改时间
    private String userRemarks;                       // 用户备注
    private String userDelFlag;                       // 用户删除标志

    public LoginInfo() {
    }

}
