package com.study.spring.sail.modules.sys.jpaImpl.dao;

import com.study.spring.sail.config.jpa.BasicRepository;
import com.study.spring.sail.modules.sys.jpaImpl.entity.SysLogin;

public interface SysLoginRepository extends BasicRepository<SysLogin, Long> {

    /**
     * 根据登陆名查询登陆账户
     *
     * @param loginName 登录名
     * @param delFlag   数据状态
     * @return
     */
    SysLogin findByLoginNameAndDelFlag(String loginName, String delFlag);

}
