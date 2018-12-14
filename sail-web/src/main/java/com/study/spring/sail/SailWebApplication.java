package com.study.spring.sail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.study.spring.sail"})
public class SailWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SailWebApplication.class);
    }

    public static void main(String[] args) {
        //Class[] objects = new Class[2];
        //objects[0] = SailServiceJpaApplication.class;
        //objects[1] = SailWebApplication.class;
        SpringApplication sa = new SpringApplication(SailWebApplication.class);
        sa.run(args);
    }

    /*public static void main(String[] args) {
        SpringApplication.run(SailWebApplication.class, args);
    }*/
}
