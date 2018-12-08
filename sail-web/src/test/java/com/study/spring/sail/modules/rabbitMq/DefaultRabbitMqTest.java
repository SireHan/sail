package com.study.spring.sail.modules.rabbitMq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultRabbitMqTest {

    @Autowired
    private DefaultSender sender;

    @Test
    public void sendTest(){
        sender.send("send a note");
    }

}