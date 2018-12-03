package com.study.spring.sail.modules.service.impl;

import com.study.spring.sail.modules.domain.SysLogin;
import com.study.spring.sail.modules.domain.SysLoginRepository;
import com.study.spring.sail.modules.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLoginServiceImpl implements SysLoginService {

    @Autowired
    private SysLoginRepository sysLoginRepository;

    @Override
    public List<SysLogin> getAllSysLogin() {
        return sysLoginRepository.findAll();
    }
}
