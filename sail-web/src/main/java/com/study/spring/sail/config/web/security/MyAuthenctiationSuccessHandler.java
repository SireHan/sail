package com.study.spring.sail.config.web.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.spring.sail.common.base.BaseOpMsg;
import com.study.spring.sail.common.status.StatusCode;
import com.study.spring.sail.modules.sys.domain.UserInfo;
import com.study.spring.sail.modules.sys.service.LoginInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 验证成功返回json
 *
 * @author 韩炜
 * @version 2018年8月29日 上午11:27:26
 */
@Component("myAuthenctiationSuccessHandler")
public class MyAuthenctiationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LoginInfoService loginInfoService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        logger.info("登录成功");

        //登陆后查询账户信息 并写入Session
        //UserInfo userInfo = loginInfoService.findCurrentUserInfo();
        //request.getSession().setAttribute(userInfo.getLogin().getLoginName(), userInfo);
        // 登录日志处理 并重置上次登录时间
        //loginInfoService.afterUserLogin(userInfo.getLogin());
        response.setContentType("application/x-www-form-urlencoded;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.getWriter().write(objectMapper.writeValueAsString(new BaseOpMsg(StatusCode.RES_SUCCESS, "登录成功", null)));
    }
}
