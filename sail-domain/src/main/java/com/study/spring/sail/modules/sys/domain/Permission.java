package com.study.spring.sail.modules.sys.domain;

import com.study.spring.sail.common.base.BaseEntity;
import lombok.Data;

/**
 * 系统信息 权限信息
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    public static final String MENU = "menu";                         // 菜单权限类型
    public static final String BUTTON = "button";                    // 按钮权限类型
    public static final String DATA = "data";                         // 数据权限类型

    private Long id;
    private String permissionType;                                      // 权限类型 0-菜单
    private String permissionName;                                      // 权限名称
    private String url;                                                   // 权限路径 （菜单URL 其他为空）

}
