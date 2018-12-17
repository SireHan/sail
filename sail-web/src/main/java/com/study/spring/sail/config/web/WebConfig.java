package com.study.spring.sail.config.web;

import com.study.spring.sail.config.web.exception.ExitException;
import com.study.spring.sail.config.web.filter.MyFilter;
import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

    /**
     * 启动遇到问题关闭服务返回状态码
     * @return
     */
    @Bean
    ExitCodeExceptionMapper exitCodeToexceptionMapper() {
        return exception -> {
            // set exit code base on the exception type
            if (exception.getCause() instanceof ExitException) {
                return 80;
            }
            return 1;
        };
    }
}
