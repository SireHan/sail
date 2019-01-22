package com.study.spring.sail.modules.basic.service;


import com.study.spring.sail.config.jpa.BasicJpaService;
import com.study.spring.sail.modules.basic.domain.City;
import com.study.spring.sail.modules.basic.jpaImpl.dao.CityCodeRepository;
import com.study.spring.sail.modules.basic.jpaImpl.entity.CityCode;
import com.study.spring.sail.modules.basic.jpaImpl.entity.QCityCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Service
public class CityCodeServiceImpl extends BasicJpaService implements CityCodeService {

    @Autowired
    private CityCodeRepository cityCodeRepository;

    @Override
    public List<City> getCityListByLevel(int level) {
        List<City> cityInfoList = new ArrayList<>();
        cityCodeRepository.findAll(QCityCode.cityCode.level.eq(level)).forEach(cityCode -> {
            City city = new City();
            BeanUtils.copyProperties(cityCode,city);
            cityInfoList.add(city);
        });
        return cityInfoList;
    }
}