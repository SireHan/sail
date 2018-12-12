package com.study.spring.sail.modules.sys.jpaImpl.entity;

import com.study.spring.sail.config.jpa.BaseAuditEntity;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class SysLogin extends BaseAuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,unique = true)
    private String loginName;       // 登录名
    @Column(nullable = false)
    private String password;        // 密码
    @Column(nullable = false)
    private String loginStatus;      // 登录状态
    @Column(nullable = false)
    private String loginType;       // 账户类型
    @Column(nullable = true,unique = true)
    private String phone;           // 手机号
    @Column(nullable = true)
    private String email;           // 邮箱
    @Column(nullable = true)
    private Long photoId;           // 头像id
    @Column(nullable = false)
    private Long userId;            // 用户id
    @Column(nullable = true)
    private String loginIp;         // 最后一次登录ip
    @Column(nullable = true)
    private Date loginDate;         // 最后一次登录时间
}
