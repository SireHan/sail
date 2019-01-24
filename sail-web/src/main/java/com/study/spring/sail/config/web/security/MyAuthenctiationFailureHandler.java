package com.study.spring.sail.config.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.spring.sail.common.base.BaseOpMsg;
import com.study.spring.sail.common.status.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 验证失败返回json
*@author 韩炜
*@version 2018年8月29日 上午11:27:26
*@Email hanwei@robustsoft.cn
*/
@Component("myAuthenctiationFailureHandler")
public class MyAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String errInfo = "系统错误";
        logger.info("登录失败");
        if (exception.getMessage().equals("Bad credentials")) {
            errInfo = "账户名或密码错误！";
        }else{
            errInfo = exception.getMessage();
        }
        // 如果是JSON，则返回JSON字符串；否则进行页面的跳转
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        response.getWriter().write(objectMapper.writeValueAsString(new BaseOpMsg(StatusCode.RES_FAILURE, errInfo,null)));

    }
}
