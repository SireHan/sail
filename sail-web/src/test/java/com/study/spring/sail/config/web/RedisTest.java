package com.study.spring.sail.config.web;

import com.study.spring.sail.modules.sys.domain.LoginInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

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
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setLoginName("testAccount");
        loginInfo.setPassword("123456");
        loginInfo.setLoginStatus("0");
        loginInfo.setLoginType("0");
        loginInfo.setUserId(1L);
        redisTemplate.opsForValue().set("sysLogin.testAccount",loginInfo);
        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("sysLogin.testAccount");
        if(exists){
            Assert.assertEquals(loginInfo.getLoginName(),((LoginInfo)redisTemplate.opsForValue().get("sysLogin.testAccount")).getLoginName());
        }
    }
}