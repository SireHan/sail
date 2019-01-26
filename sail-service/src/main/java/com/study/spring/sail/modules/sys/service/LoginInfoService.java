package com.study.spring.sail.modules.sys.service;

import com.study.spring.sail.modules.sys.domain.Login;
import com.study.spring.sail.modules.sys.domain.UserInfo;

/**
 * 账户信息 and 用户信息 service
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
public interface LoginInfoService {

    /**
     * 根据用户名查询账户信息
     *
     * @param loginName
     * @return
     */
    Login findLoginByName(String loginName);

    /**
     * 获取账户所有信息
     *
     * @param loginName
     * @return
     */
    UserInfo getUserInfo(String loginName);
}
