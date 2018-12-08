package com.study.spring.sail.modules.rabbitMq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnExpression("${spring.rabbitmq.config}")
public class DefaultSender {

    private Logger logger = LoggerFactory.getLogger(DefaultSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String content){
        logger.info("Sender:"+content);
        amqpTemplate.convertAndSend("default",content);
    }
}
