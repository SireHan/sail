package com.study.spring.sail.modules.sys.jpaImpl.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * sys_user_role 系统用户角色表
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
@Entity
public class SysUserRole {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long userId;                                      // 用户id
    @Column(nullable = false)
    private String roleId;                                    // 角色id

}
