package com.study.spring.sail.modules.sys.service;


import com.study.spring.sail.common.status.StatusCode;
import com.study.spring.sail.config.exception.api.NotFoundException;
import com.study.spring.sail.modules.sys.domain.Login;
import com.study.spring.sail.modules.sys.jpaImpl.dao.SysLoginRepository;
import com.study.spring.sail.modules.sys.domain.LoginInfo;
import com.study.spring.sail.modules.sys.jpaImpl.entity.SysLogin;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {

    @Autowired
    private SysLoginRepository sysLoginRepository;

    @Override
    public Login findLoginByName(String loginName) {
        return sysLoginRepository.findByLoginNameAndDelFlag(loginName,StatusCode.DEL_FLAG_AUDIT).transLogin();
    }
}
