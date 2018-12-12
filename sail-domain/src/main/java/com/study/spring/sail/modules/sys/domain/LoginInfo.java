package com.study.spring.sail.modules.sys.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String loginName;       // 登录名
    private String password;        // 密码
    private String loginStatus;      // 登录状态
    private String loginType;       // 账户类型
    private String phone;           // 手机号
    private String email;           // 邮箱
    private Long photoId;           // 头像id
    private Long userId;            // 用户id
    private String loginIp;         // 最后一次登录ip
    private Date loginDate;         // 最后一次登录时间
    private Long createBy;          // 创建人
    private Date createDate;        // 创建时间
    private Long updateBy;          // 修改人
    private Date updateDate;        // 修改时间
    private String remarks;         // 备注
    private String delFlag;         // 删除标志

    public LoginInfo() {
    }

    public LoginInfo(Long id, String loginName, String password, String loginStatus, String loginType, String phone, String email, Long photoId, Long userId, String loginIp, Date loginDate, Long createBy, Date createDate, Long updateBy, Date updateDate, String remarks, String delFlag) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
        this.loginStatus = loginStatus;
        this.loginType = loginType;
        this.phone = phone;
        this.email = email;
        this.photoId = photoId;
        this.userId = userId;
        this.loginIp = loginIp;
        this.loginDate = loginDate;
        this.createBy = createBy;
        this.createDate = createDate;
        this.updateBy = updateBy;
        this.updateDate = updateDate;
        this.remarks = remarks;
        this.delFlag = delFlag;
    }

}
