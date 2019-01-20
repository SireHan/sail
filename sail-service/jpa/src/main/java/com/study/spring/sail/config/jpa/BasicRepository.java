package com.study.spring.sail.config.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.io.Serializable;


@NoRepositoryBean
public interface BasicRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T>{

}
