package com.study.spring.sail.config.jpa;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Pageable;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * JPA QueryDSL 基本查询类
 *
 * @author 韩炜
 * @date 2019-01-17 16:27
 */
public abstract class BasicJpaService {

    @PersistenceContext
    private EntityManager entityManager;

    // 查询工厂实体
    public JPAQueryFactory queryFactory;

    @PostConstruct
    public void init() {
        queryFactory = new JPAQueryFactory(entityManager);
    }

    // 多表分页自定义查询
    public QueryResults<Tuple> findTupleByPage(JPAQuery<Tuple> jpaQuery, Predicate predicate, Pageable pageable) {
        return jpaQuery.where(predicate).offset(pageable.getOffset()).limit(pageable.getPageSize()).fetchResults();
    }

    public QueryResults<Tuple> findTupleByPage(JPAQuery<Tuple> jpaQuery, Pageable pageable) {
        return jpaQuery.offset(pageable.getOffset()).limit(pageable.getPageSize()).fetchResults();
    }

    // 多表自定义查询
    public List<Tuple> findTuple(JPAQuery<Tuple> jpaQuery, Predicate predicate) {
        return jpaQuery.where(predicate).fetch();
    }

}
