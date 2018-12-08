package com.study.spring.sail.modules.sys.jpaImpl.dao.mybatis;

import com.study.spring.sail.modules.sys.SysLogin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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