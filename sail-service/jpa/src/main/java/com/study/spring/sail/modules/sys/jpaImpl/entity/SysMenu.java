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
public class SysMenu extends BaseAuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = true)
    private Long parentId;                                      // 父菜单id
    @Column(nullable = true)
    private String parentIds;                                   // 上级菜单
    @Column(nullable = false,unique = true)
    private String menuName;                                    // 菜单名称
    @Column(nullable = false,unique = true)
    private String menuCode;                                    // 菜单代码
    @Column(nullable = true)
    private String menuHref;                                    // 菜单访问路径
    @Column(nullable = true)
    private Integer menuTarget;                                // 菜单打开方式
    @Column(nullable = true)
    private String menuIcon;                                   // 菜单图标
    @Column(nullable = false)
    private String menuStatus;                                 // 菜单状态
    @Column(nullable = false)
    private String menuType;                                   // 菜单类型

}
