package com.study.spring.sail.modules.sys.service;

import com.study.spring.sail.modules.sys.domain.Login;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author 韩炜
 * @date 2019-01-26 17:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:test.properties")
public class LoginInfoServiceImplTest {

    @Autowired
    private LoginInfoService sysLoginService;

    @Test
    public void findLoginByName() {
        Login login = sysLoginService.findLoginByName("admin");
        Assert.assertEquals(login.getLoginName(), "admin");
    }
}