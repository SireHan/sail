package com.study.spring.sail.modules.sys.service;

import com.study.spring.sail.modules.sys.domain.Login;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * 账户信息 and 用户信息 service
 */
public interface LoginInfoService {

    /**
     * 根据用户名查询账户信息
     * @param loginName
     * @return
     */
    Login findLoginByName(String loginName);
}
