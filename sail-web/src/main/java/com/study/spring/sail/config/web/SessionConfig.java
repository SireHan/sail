package com.study.spring.sail.config.web;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * spring redis session 设置 跨域 cookie 设置
 *
 * @author 韩炜
 * @date 2019-01-24 15:40
 */
@Configuration
@ConditionalOnExpression("${spring.redis.config}")
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class SessionConfig {
    @Bean
    public CookieSerializer httpSessionIdResolver() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        // 取消samesite
        cookieSerializer.setSameSite(null);
        return cookieSerializer;
    }
}
