package com.study.spring.sail.config.web;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${spring.rabbitmq.config}")
public class RabbitConfig {

    /**
     * 默认队列
     * @return
     */
    @Bean
    public Queue DefaultQueue(){
        return new Queue("default");
    }
}
