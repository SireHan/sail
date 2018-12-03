package com.study.spring.sail.modules.service;

import com.study.spring.sail.modules.domain.SysLogin;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface SysLoginService {

    @Cacheable(value="sysLogin-all")
    public List<SysLogin> getAllSysLogin();
}
