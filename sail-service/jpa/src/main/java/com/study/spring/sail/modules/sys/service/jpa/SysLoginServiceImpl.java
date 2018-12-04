package com.study.spring.sail.modules.sys.service.jpa;


import com.study.spring.sail.domain.modules.sys.SysLogin;
import com.study.spring.sail.modules.sys.dao.jpa.SysLoginRepository;
import com.study.spring.sail.modules.sys.service.SysLoginService;
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
