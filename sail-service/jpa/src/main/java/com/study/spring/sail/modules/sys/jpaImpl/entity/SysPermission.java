package com.study.spring.sail.modules.sys.jpaImpl.entity;

import com.study.spring.sail.config.jpa.BaseAuditEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * sys_permission 系统权限表
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
@Entity
public class SysPermission extends BaseAuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String permissionType;                                      // 权限类型
    @Column(nullable = false)
    private String permissionName;                                      // 权限对应的id

}
