package com.study.spring.sail.modules.sys.jpaImpl.dao;

import com.study.spring.sail.modules.sys.jpaImpl.entity.SysLogin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//@RunWith(SpringRunner.class)
//@DataJpaTest
public class DataJPARepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SysLoginRepository sysLoginRepository;

    //@Test
    public void curd_sysLogin() {
        // given
        SysLogin sysLogin = new SysLogin();
        String loginName = "account"+(new Date()).getTime();
        sysLogin.setLoginName(loginName);
        sysLogin.setPassword("123456");
        sysLogin.setCreateBy(0L);
        sysLogin.setCreateDate(new Date());
        sysLogin.setDelFlag("0");
        sysLogin.setLoginStatus("0");
        sysLogin.setLoginType("0");
        sysLogin.setUserId(1L);
        entityManager.persistAndFlush(sysLogin);

        // when
        SysLogin found = sysLoginRepository.findByLoginName(sysLogin.getLoginName());

        // then
        Assert.assertEquals(found.getLoginName(),sysLogin.getLoginName());
    }
}
