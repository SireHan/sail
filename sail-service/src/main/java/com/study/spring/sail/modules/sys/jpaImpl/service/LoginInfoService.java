package com.study.spring.sail.modules.sys.jpaImpl.service;

import com.study.spring.sail.modules.sys.domain.LoginInfo;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface LoginInfoService {

    /**
     *  查询所有登录账户
     * @return
     */
    @Cacheable(value="loginInfo-all")
    public List<LoginInfo> getAllLoginInfo();

    /**
     *  根据id 查询登录账户
     * @param id
     * @return
     */
    LoginInfo findById(Long id);
}
