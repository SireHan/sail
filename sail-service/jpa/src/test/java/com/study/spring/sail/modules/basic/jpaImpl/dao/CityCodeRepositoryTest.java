package com.study.spring.sail.modules.basic.jpaImpl.dao;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.spring.sail.modules.basic.jpaImpl.entity.CityCode;
import com.study.spring.sail.modules.basic.jpaImpl.entity.QCityCode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:test.properties")
public class CityCodeRepositoryTest {

    @Autowired
    private CityCodeRepository cityCodeRepository;

    @Autowired
    private EntityManager entityManager;

    //JPA查询工厂
    private JPAQueryFactory queryFactory;

    @Before
    public void initFactory() {
        queryFactory = new JPAQueryFactory(entityManager);

    }


    /**
     * 只有查询测试
     * 根据code查询，根据id查询，根据等级查询，根据父级查询，分页查询
     *
     * @throws Exception
     */
    @Test
    public void curdTest() throws Exception {
        // Example 查詢方式
        CityCode cityCode = new CityCode();
        cityCode.setName("桓");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", contains());
        Example<CityCode> example = Example.of(cityCode, matcher);
        List<CityCode> cityList = cityCodeRepository.findAll(example);
        for (CityCode city : cityList) {
            System.out.println(city.getName() + ":" + city.getMergerName());
        }
        // 分页查询
        int page = 1, size = 10;
        Page<CityCode> users = cityCodeRepository.findAll(PageRequest.of(1, 20));

        // QueryDSL 单表查询
        QCityCode qCityCode = QCityCode.cityCode;
        List<CityCode> dslCityList = (List<CityCode>) queryFactory.from(qCityCode)
                .where(qCityCode.name.like("桓"))
                .orderBy(qCityCode.code.asc()).fetch();
        for (CityCode city : cityList) {
            System.out.println(city.getName() + ":" + city.getMergerName());
        }

        cityCodeRepository.findAll(qCityCode.code.eq("010"));
    }

}