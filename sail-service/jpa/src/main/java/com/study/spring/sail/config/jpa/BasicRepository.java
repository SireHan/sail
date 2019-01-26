package com.study.spring.sail.config.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.io.Serializable;

/**
 * JPA repository 基本类
 *
 * @author 韩炜
 * @date 2019-01-17 16:27
 */
@NoRepositoryBean
public interface BasicRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T>{

}
