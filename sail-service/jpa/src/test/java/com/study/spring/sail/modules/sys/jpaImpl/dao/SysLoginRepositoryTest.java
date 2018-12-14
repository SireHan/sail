package com.study.spring.sail.modules.sys.jpaImpl.dao;

import com.study.spring.sail.modules.sys.jpaImpl.entity.SysLogin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:test.properties")
public class SysLoginRepositoryTest {

    @Autowired
    private SysLoginRepository sysLoginRepository;

    @Test
    public void curdTest() throws Exception{
        SysLogin sysLogin = new SysLogin();
        String loginName = "account"+(new Date()).getTime();
        sysLogin.setLoginName(loginName);
        sysLogin.setPassword("123456");
        sysLogin.setCreateBy(0L);
        sysLogin.setDelFlag("0");
        sysLogin.setLoginStatus("0");
        sysLogin.setLoginType("0");
        sysLogin.setUserId(1L);
        // 新增测试
        sysLoginRepository.save(sysLogin);
        // 查询测试
        Assert.assertEquals(1,sysLoginRepository.findAll().size());
        Assert.assertEquals(loginName,sysLoginRepository.findByLoginName(loginName).getLoginName());
        Assert.assertEquals(loginName,sysLoginRepository.findById(sysLogin.getId()).get().getLoginName());
        // 修改测试
        // 删除测试
        sysLoginRepository.delete(sysLogin);
        // 分页查询
        int page = 1, size = 10;
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Page<SysLogin> pageSysLogin = sysLoginRepository.findAll(PageRequest.of(page,size,sort));

    }

}