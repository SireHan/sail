package com.study.spring.sail.modules.sys.service;

import com.study.spring.sail.common.base.BaseEntity;
import com.study.spring.sail.modules.sys.domain.Login;
import com.study.spring.sail.modules.sys.domain.UserInfo;
import com.study.spring.sail.modules.sys.jpaImpl.dao.SysLoginRepository;
import com.study.spring.sail.modules.sys.jpaImpl.entity.SysLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        } else {

        }
        return userInfo;
    }
}
