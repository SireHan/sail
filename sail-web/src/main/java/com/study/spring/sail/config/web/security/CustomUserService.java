package com.study.spring.sail.config.web.security;

import java.util.ArrayList;
import java.util.List;

import com.study.spring.sail.common.base.BaseEntity;
import com.study.spring.sail.modules.sys.domain.Login;
import com.study.spring.sail.modules.sys.service.LoginInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * 自定义账户登录查询
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Service
public class CustomUserService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoginInfoService loginInfoService;

    /*
     * 重写loadUserByUsername方法获得 userdetails
     */
    @Override
    public UserDetails loadUserByUsername(String loginName) {
        //根据账户名查询
        Login login = loginInfoService.findLoginByName(loginName);
        if (login == null) {
            throw new BadCredentialsException("账户不存在");
        } else if ((BaseEntity.DISABLE_STATUS + "").equals(login.getLoginStatus())) {
            throw new BadCredentialsException("账户已经禁用，请联系管理员！");
        }
        logger.info(login.getLoginName() + " 正在登录...");
        // 获取用户角色
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (Login.ADMIN.equals(login.getLoginType())) { // 超级用户角色
            authorities.add(new SimpleGrantedAuthority("ROLE_" + "admin"));
        } else {
            // TODO 查询账户角色
        }
        UserDetails userDetails = new User(loginName, login.getPassword(), authorities);
        return userDetails;
    }
}

