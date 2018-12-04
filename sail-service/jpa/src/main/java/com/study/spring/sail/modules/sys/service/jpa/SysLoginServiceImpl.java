package com.study.spring.sail.service.modules.sys.jpa;


import com.study.spring.sail.domain.modules.sys.SysLogin;
import com.study.spring.sail.service.modules.sys.SysLoginService;
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
