package com.study.spring.sail.modules.basic.service;

import com.study.spring.sail.modules.basic.domain.City;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


/**
 * 城市代码 service
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
public interface CityCodeService {

    /**
     * 查询某个级别的城市
     *
     * @return
     */
    @Cacheable(value = "cityCode-level")
    List<City> getCityListByLevel(int level);

    /**
     * 查询某个父级下面的城市
     *
     * @param parentId
     * @return
     */
    @Cacheable(value = "cityCode-parent")
    List<City> getCityListByParent(Long parentId);
}
