package com.study.spring.sail.modules.sys.domain;

import com.study.spring.sail.common.base.BaseEntity;
import lombok.Data;

@Data
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;
    public static final String MENU = "menu";                       // 菜单权限类型

    private Long id;
    private String permissionType;                                      // 权限类型
    private String permissionName;                                      // 权限名称
    private String url;                                                   // 权限路径 （菜单）

}
