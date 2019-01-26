package com.study.spring.sail.modules.api.basic;

import com.study.spring.sail.modules.basic.domain.City;
import com.study.spring.sail.modules.basic.domain.Tree;
import com.study.spring.sail.modules.basic.service.CityCodeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 城市city API
 *
 * @author 韩炜
 * @date 2019-01-14 9:54
 */
@RestController
@RequestMapping("/api/basic/city")
public class CityController {

    @Autowired
    private CityCodeService cityCodeService;

    @ApiOperation(value = "根据父级查询行政区划", notes = "父级为空显示所有第一层级的行政区划，否则显示父级的子行政区划")
    @ApiImplicitParam(name = "parentId", value = "父行政区划id", paramType = "query", dataType = "Long")
    @GetMapping("/loadCityList")
    public List<Tree> loadCityList(Long parentId) {
        if (parentId == null) {
            return cityCodeService.getCityListByLevel(1).stream().map(City::transTree).collect(Collectors.toList());
        } else {
            return cityCodeService.getCityListByParent(parentId).stream().map(City::transTree).collect(Collectors.toList());
        }
    }
}
