package com.study.spring.sail.modules.sys.jpaImpl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class SysRolePermission {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long roleId;                                      // 角色id
    @Column(nullable = false)
    private Long permissionType;                             // 权限类型
    @Column(nullable = false)
    private String permissionIds;                             // 权限ids

}
