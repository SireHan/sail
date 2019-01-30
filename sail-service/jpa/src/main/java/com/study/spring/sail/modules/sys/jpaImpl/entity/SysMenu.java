package com.study.spring.sail.modules.sys.jpaImpl.entity;

import com.study.spring.sail.config.jpa.BaseAuditEntity;
import com.study.spring.sail.modules.sys.domain.Menu;
import com.study.spring.sail.modules.sys.domain.Permission;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * sys_menu 系统菜单表
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
@Entity
public class SysMenu extends BaseAuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long parentId;                                      // 父菜单id
    @Column
    private String parentIds;                                   // 上级菜单
    @Column(nullable = false, unique = true)
    private String menuName;                                    // 菜单名称
    @Column(nullable = false, unique = true)
    private String menuCode;                                    // 菜单代码
    @Column(nullable = true)
    private String menuHref;                                    // 菜单访问路径
    @Column
    private Integer menuTarget;                                // 菜单打开方式
    @Column
    private String menuIcon;                                   // 菜单图标
    @Column(nullable = false)
    private String menuStatus;                                 // 菜单状态
    @Column(nullable = false)
    private String menuType;                                   // 菜单类型  0-根目录 1-菜单（含有子节点） 2-菜单（不含有子节点）
    @Column(nullable = false)
    private Long permissionId;                                // 权限id

    public Permission transPermission() {
        Permission permission = new Permission();
        permission.setPermissionType(Permission.MENU);
        permission.setId(this.permissionId);
        permission.setUrl(this.menuHref);
        return permission;
    }

    public Menu transMenu() {
        Menu menu = new Menu();
        BeanUtils.copyProperties(this, menu);
        return menu;
    }
}
