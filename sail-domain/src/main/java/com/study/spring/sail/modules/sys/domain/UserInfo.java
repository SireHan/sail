package com.study.spring.sail.modules.sys.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统信息 用户详细信息
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
public class UserInfo {
    // 帐户信息
	private Login login;
    // 用户信息
    private User user;
    // 是否是管理员
    private boolean isAdmin = false;
    // 角色信息
	private List<Role> roleList;
    // 权限信息
    private List<Permission> permissionList;

    // 首页路由地址
	private String homeRoute;
	
	public UserInfo() {
		roleList = new ArrayList<>();
		permissionList = new ArrayList<>();
	}
	
}
