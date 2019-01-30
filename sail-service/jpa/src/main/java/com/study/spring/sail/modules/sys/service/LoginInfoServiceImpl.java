package com.study.spring.sail.modules.sys.service;

import com.study.spring.sail.common.base.BaseEntity;
import com.study.spring.sail.common.status.CacheKey;
import com.study.spring.sail.common.util.CacheUtil;
import com.study.spring.sail.modules.basic.domain.Tree;
import com.study.spring.sail.modules.sys.domain.Login;
import com.study.spring.sail.modules.sys.domain.Menu;
import com.study.spring.sail.modules.sys.domain.UserInfo;
import com.study.spring.sail.modules.sys.jpaImpl.dao.SysLoginRepository;
import com.study.spring.sail.modules.sys.jpaImpl.dao.SysMenuRepository;
import com.study.spring.sail.modules.sys.jpaImpl.entity.QSysMenu;
import com.study.spring.sail.modules.sys.jpaImpl.entity.SysLogin;
import com.study.spring.sail.modules.sys.jpaImpl.entity.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 账户信息 and 用户信息 serviceImpl
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Service
public class LoginInfoServiceImpl implements LoginInfoService {

    @Autowired
    private SysLoginRepository sysLoginRepository;
    @Autowired
    private SysMenuRepository sysMenuRepository;

    @Override
    public Login findLoginByName(String loginName) {
        SysLogin sysLogin = sysLoginRepository.findByLoginNameAndDelFlag(loginName, BaseEntity.DEL_FLAG_NORMAL);
        if (sysLogin != null) {
            return sysLogin.transLogin();
        }
        return null;
    }

    @Override
    public UserInfo getUserInfo(String loginName) {
        UserInfo userInfo = null;
        // 先查询当前用户 用户不存在返回null
        SysLogin sysLogin = sysLoginRepository.findByLoginNameAndDelFlag(loginName, BaseEntity.DEL_FLAG_NORMAL);
        if (sysLogin == null) {
            return userInfo;
        }
        userInfo = new UserInfo();
        userInfo.setLogin(sysLogin.transLogin());
        // 判断是否为超级管理员 管理员查所有权限
        if (Login.ADMIN.equals(sysLogin.getLoginType())) {
            // 查询出所有菜单 不必判断权限
            userInfo.setAdmin(true);
            QSysMenu qSysMenu = QSysMenu.sysMenu;
            List<SysMenu> sysMenuList = (List<SysMenu>) sysMenuRepository.findAll(qSysMenu.delFlag.eq(BaseEntity.DEL_FLAG_NORMAL).and(qSysMenu.menuStatus.eq(BaseEntity.START_STATUS)));
            // 形成一棵菜单树
            List<Menu> menuList = sysMenuList.stream().map(sysMenu -> sysMenu.transMenu()).collect(Collectors.toList());
            Tree<Menu> menuTree = Menu.transTree(null, menuList);
            userInfo.setMenuTree(menuTree);
        } else {

        }
        // 用户信息写入缓存
        CacheUtil.cacheUserInfo(loginName, userInfo);
        return userInfo;
    }
}
