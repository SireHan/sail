package com.study.spring.sail.modules.sys.service;


import com.study.spring.sail.common.base.BaseEntity;
import com.study.spring.sail.config.exception.api.NotFoundException;
import com.study.spring.sail.modules.sys.domain.LoginInfo;
import com.study.spring.sail.modules.sys.domain.Permission;
import com.study.spring.sail.modules.sys.jpaImpl.dao.SysLoginRepository;
import com.study.spring.sail.modules.sys.jpaImpl.dao.SysMenuRepository;
import com.study.spring.sail.modules.sys.jpaImpl.dao.SysPermissionRepository;
import com.study.spring.sail.modules.sys.jpaImpl.entity.QSysMenu;
import com.study.spring.sail.modules.sys.jpaImpl.entity.SysLogin;
import com.study.spring.sail.modules.sys.jpaImpl.entity.SysMenu;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SysPermissionRepository sysPermissionRepository;
    @Autowired
    private SysMenuRepository sysMenuRepository;

    @Override
    public List<Permission> findUrlPermission() {
        // 因为目前只有菜单
        List<SysMenu> sysMenuList = (List<SysMenu>)sysMenuRepository.findAll(QSysMenu.sysMenu.delFlag.eq(BaseEntity.DEL_FLAG_NORMAL));
        return sysMenuList.stream().map(sysMenu -> sysMenu.transPermission()).collect(Collectors.toList());
    }
}
