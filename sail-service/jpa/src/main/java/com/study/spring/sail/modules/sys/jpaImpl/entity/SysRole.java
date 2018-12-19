package com.study.spring.sail.modules.sys.jpaImpl.entity;

import com.study.spring.sail.config.jpa.BaseAuditEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class SysRole extends BaseAuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String roleName;                                        // 角色名称
    @Column
    private String roleEname;                                       // 英文名称
    @Column(nullable = false)
    private String roleType;                                        // 角色类型
    @Column(nullable = false)
    private String roleStatus;                                      // 角色状态

}
