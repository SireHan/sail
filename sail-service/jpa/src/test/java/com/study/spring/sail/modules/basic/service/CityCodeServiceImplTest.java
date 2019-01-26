package com.study.spring.sail.modules.basic.service;

import com.study.spring.sail.modules.basic.domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 韩炜
 * @date 2019-01-26 17:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:test.properties")
public class CityCodeServiceImplTest {

    @Autowired
    private CityCodeService cityCodeService;

    @Test
    public void getCityListByLevel() {
        List<City> cityList = cityCodeService.getCityListByLevel(1);
        for (City city : cityList) {
            System.out.println(city);
        }
    }

    @Test
    public void getCityListByParent() {
        List<City> cityList = cityCodeService.getCityListByParent(2L);
        for (City city : cityList) {
            System.out.println(city);
        }
    }
}