package com.study.spring.sail.modules.api;

import com.study.spring.sail.modules.sys.domain.LoginInfo;
import com.study.spring.sail.modules.sys.jpaImpl.service.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 账户信息API
 */
@RestController
@RequestMapping("/api/loginInfo")
public class LoginInfoAPIController {

    @Autowired
    private LoginInfoService loginInfoService;

    @GetMapping("/{id}")
    public LoginInfo findOne(@PathVariable Long id){
        return loginInfoService.findById(id);
    }

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
