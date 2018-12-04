package com.study.spring.sail.modules.sys.dao.mybatis;

import com.study.spring.sail.domain.modules.sys.SysLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysLoginMapper {

    /**
     * 根据登陆名查询登陆账户
     * @param loginName
     * @return
     */
    @Select("select * from sys_login where login_name = #{loginName}")
    SysLogin findByLoginName(String loginName);

}
