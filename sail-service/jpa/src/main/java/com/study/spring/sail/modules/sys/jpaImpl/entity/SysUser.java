package com.study.spring.sail.modules.sys.jpaImpl.entity;

import com.study.spring.sail.config.jpa.BaseAuditEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * sys_user 系统用户表
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
@Entity
public class SysUser extends BaseAuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;                                // 姓名
    @Column
    private String sex;                                 // 性别
    @Column
    private String idCard;                             // 身份标识
    @Column(nullable = false)
    private String userType;                           // 用户类型
    @Column(nullable = false)
    private String userStatus;                         // 用户状态
    @Column
    private Long orgId;                                 // 机构id
    @Column
    private Long areaId;                                // 地区id
    @Column
    private String jsonInfo;                           // 其他信息json

}
