package com.study.spring.sail.modules.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLoginMapperTest {

    @Autowired
    private SysLoginMapper sysLoginMapper;

    @Test
    public void curdTest() throws Exception{
        SysLogin sysLogin = sysLoginMapper.findByLoginName("testAccount");
        System.out.println(sysLogin.getId());
    }

}