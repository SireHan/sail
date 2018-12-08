package com.study.spring.sail.modules.sys.jpaImpl.service;

import com.study.spring.sail.modules.sys.domain.LoginInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginInfoServiceTest {

    @Autowired
    private LoginInfoService sysLoginService;

    @Test
    public void getAllSysLogin() {
        List<LoginInfo> sysLoginList = sysLoginService.getAllLoginInfo();
        for(LoginInfo sysLogin:sysLoginList){
            System.out.println(sysLogin.getLoginName());
        }
    }
}