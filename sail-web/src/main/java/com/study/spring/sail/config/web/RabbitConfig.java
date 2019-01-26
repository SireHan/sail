package com.study.spring.sail.config.web;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq 设置
 *
 * @author 韩炜
 * @date 2019-01-24 15:40
 */
@Configuration
@ConditionalOnExpression("${spring.rabbitmq.config}")
public class RabbitConfig {

    /**
     * 默认队列
     *
     * @return
     */
    @Bean
    public Queue DefaultQueue() {
        return new Queue("default");
    }
}
