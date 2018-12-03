package com.study.spring.sail.modules.service;

import com.study.spring.sail.modules.domain.SysLogin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLoginServiceTest {

    @Autowired
    private SysLoginService sysLoginService;

    @Test
    public void getAllSysLogin() {
        List<SysLogin> sysLoginList = sysLoginService.getAllSysLogin();
        for(SysLogin sysLogin:sysLoginList){
            System.out.println(sysLogin.getLoginName());
        }
    }
}