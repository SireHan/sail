package com.study.spring.sail.config.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * spring security 配置
 *
 * @author 韩炜
 * @date 2019-01-24 15:40
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MySecurityMetadataSource myFilterInvocationSecurityMetadataSource;
    @Autowired
    MyAccessDecisionManager myAccessDecisionManager;

    @Autowired
    AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;
    @Autowired
    private MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;
    @Autowired
    private MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;

    /*@Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;*/


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/sys/loginValidator", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/api/sys/login")
                .successHandler(myAuthenctiationSuccessHandler)
                .failureHandler(myAuthenctiationFailureHandler)
                .permitAll().and().logout().logoutSuccessUrl("/").permitAll().deleteCookies()  //删除cookie
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(myAccessDecisionManager);
                        o.setSecurityMetadataSource(myFilterInvocationSecurityMetadataSource);
                        return o;
                    }
                }).and().cors().and().csrf().disable().exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);

    }

    /**
     * BCrypt加密
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

}
