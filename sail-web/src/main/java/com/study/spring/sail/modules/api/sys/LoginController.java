package com.study.spring.sail.modules.api.sys;

import com.study.spring.sail.modules.basic.domain.City;
import com.study.spring.sail.modules.basic.domain.Tree;
import com.study.spring.sail.modules.basic.service.CityCodeService;
import com.study.spring.sail.modules.sys.domain.Login;
import com.study.spring.sail.modules.sys.service.LoginInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * city API
 * @author 韩炜
 * @date 2019-01-14 9:54
 */
@RestController
@RequestMapping("/api/sys")
public class LoginController {

    @Autowired
    private LoginInfoService loginInfoService;

    @ApiOperation(value = "登录验证",notes = "验证用户是否登录")
    @ApiImplicitParam(name = "loginValidator", value = "账户信息", paramType = "query", dataType = "Login")
    @GetMapping("/loginValidator")
    public String loginValidator(Login login){
        return "";
    }
}
