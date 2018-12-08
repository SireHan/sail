package com.study.spring.sail.modules.sys.jpaImpl.service;


import com.study.spring.sail.config.exception.api.NotFoundException;
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
    public List<LoginInfo> getAllLoginInfo() {
        List<LoginInfo> loginInfoList = new ArrayList<>();
        List<SysLogin> sysLoginList = sysLoginRepository.findAll();
        BeanUtils.copyProperties(sysLoginList, loginInfoList);
        return loginInfoList;
    }

    @Override
    public LoginInfo findById(Long id) {
        LoginInfo loginInfo = new LoginInfo();
        SysLogin sysLogin = sysLoginRepository.findById(id).orElseThrow(NotFoundException::new);
        BeanUtils.copyProperties(sysLogin, loginInfo);
        return loginInfo;
    }
}
