package com.study.spring.sail.modules.sys.service;

import com.study.spring.sail.modules.sys.domain.LoginInfo;
import com.study.spring.sail.modules.sys.domain.Permission;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 权限信息service
 */
public interface PermissionService {

    /**
     * 查询所有含有url路径的权限信息 （目前只有菜单）
     * @return
     */
    List<Permission> findUrlPermission();
}
