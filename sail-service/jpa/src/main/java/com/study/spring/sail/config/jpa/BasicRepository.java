package com.study.spring.sail.config.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

public interface BasicRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {

}
