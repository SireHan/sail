package com.study.spring.sail.modules.rabbitMq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "default")
@ConditionalOnExpression("${spring.rabbitmq.config}")
public class DefaultReceiver {

    private Logger logger = LoggerFactory.getLogger(DefaultReceiver.class);

    @RabbitHandler
    public void process(String content){
        logger.info("Receiver:"+content);
    }
}
