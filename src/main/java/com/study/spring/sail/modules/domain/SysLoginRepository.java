package com.study.spring.sail.modules.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SysLoginRepository extends JpaRepository<SysLogin,Long> {

    SysLogin findByLoginName(String loginName);

}
