package com.study.spring.sail.modules.basic.service;

import com.study.spring.sail.modules.basic.domain.City;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface CityCodeService {

    /**
     *  查询某个级别的城市
     * @return
     */
    @Cacheable(value="cityCode-level")
    public List<City> getCityListByLevel(int level);

}
