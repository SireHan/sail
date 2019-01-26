package com.study.spring.sail.modules.sys.service;

import com.study.spring.sail.modules.sys.domain.Permission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 韩炜
 * @date 2019-01-26 17:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:test.properties")
public class PermissionServiceImplTest {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void findUrlPermission() {
        List<Permission> permissionList = permissionService.findUrlPermission();
        for (Permission permission : permissionList) {
            System.out.println(permission);
        }
    }
}