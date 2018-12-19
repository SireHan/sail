package com.study.spring.sail.config.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface BasicRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {

}
