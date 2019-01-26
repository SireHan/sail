package com.study.spring.sail.modules.sys.service;

import com.study.spring.sail.modules.sys.domain.Permission;

import java.util.List;

/**
 * 权限信息service
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
public interface PermissionService {

    /**
     * 查询所有含有url路径的权限信息 （目前只有菜单）
     *
     * @return
     */
    List<Permission> findUrlPermission();
}
