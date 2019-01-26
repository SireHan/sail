package com.study.spring.sail.config.web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.NotNull;

/**
 * 自定义资源加载 properties
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Configuration
@ConfigurationProperties(prefix = "project")
@PropertySource("classpath:sail.properties")
public class SourceProperties {

    @NotNull
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
