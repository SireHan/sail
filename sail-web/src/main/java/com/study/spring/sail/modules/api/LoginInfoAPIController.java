package com.study.spring.sail.modules.api;

import com.study.spring.sail.modules.sys.domain.LoginInfo;
import com.study.spring.sail.modules.sys.service.LoginInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 账户信息API
 */
@RestController
@RequestMapping("/api/loginInfo")
@Api("登录账户信息api")
public class LoginInfoAPIController {

    @Autowired
    private LoginInfoService loginInfoService;

    @ApiOperation(value = "根据id查询登录账户",notes = "只显示登录账户信息")
    @ApiImplicitParam(name = "id", value = "登录账户ID", paramType = "path", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public LoginInfo findOne(@PathVariable Long id){
        return loginInfoService.findById(id);
    }

    @ApiOperation(value = "查询所有登录账户信息")
    @GetMapping
    public List<LoginInfo> findAllLoginInfo(){
        return loginInfoService.getAllLoginInfo();
    }

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoginInfo create(@RequestBody LoginInfo loginInfo) {
        return loginInfoService.save(loginInfo);
    }*/
}
