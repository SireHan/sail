package com.study.spring.sail.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.study.spring.sail.modules.**.jpaImpl.dao")
@EntityScan("com.study.spring.sail.modules.**.jpaImpl.entity")
@Configuration
public class JpaConfig {
}
