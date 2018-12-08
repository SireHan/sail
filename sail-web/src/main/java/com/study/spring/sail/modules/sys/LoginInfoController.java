package com.study.spring.sail.modules.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginInfoController {

    @RequestMapping("/home")
    public String home(){
        return "modules/home";
    }

    @RequestMapping("/errorExample")
    public String errorExample() throws Exception {
        throw new Exception();
    }


}
