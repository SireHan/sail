package com.study.spring.sail.modules.api;

import com.study.spring.sail.config.web.exception.ExitException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @RequestMapping("/sessionId")
    public String sessionId(HttpSession session){
        UUID uid = (UUID)session.getAttribute("uid");
        if(uid == null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return session.getId();
    }

    @RequestMapping("/shutdown")
    public Integer shutdown() throws ExitException{
        try{
            return Integer.parseInt("test");
        }catch (Exception e){
            throw  new ExitException("error",e);
        }
    }
}
