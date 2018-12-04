package com.study.spring.sail.web.config;

import com.study.spring.sail.modules.domain.SysLogin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void readAndWriteString() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa","1212");
        Assert.assertEquals("1212",stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void readAndWriteObject() throws Exception {
        SysLogin sysLogin = new SysLogin();
        sysLogin.setLoginName("testAccount");
        sysLogin.setPassword("123456");
        sysLogin.setCreateBy(0L);
        sysLogin.setCreateDate(new Date());
        sysLogin.setDelFlag("0");
        sysLogin.setLoginStatus("0");
        sysLogin.setLoginType("0");
        sysLogin.setUserId(1L);
        redisTemplate.opsForValue().set("sysLogin.testAccount",sysLogin);
        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("sysLogin.testAccount");
        if(exists){
            Assert.assertEquals(sysLogin.getLoginName(),((SysLogin)redisTemplate.opsForValue().get("sysLogin.testAccount")).getLoginName());
        }
    }
}