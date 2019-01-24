package com.study.spring.sail.modules.sys.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *@author 韩炜
 *@version 2018年8月30日 下午1:33:47
 */
@Data
public class UserInfo {
	//帐户信息
	private Login login;
	//是否是管理员
	private boolean admin = false; 
	//权限信息
	private List<Permission> permissionList;
	//角色信息
	private List<Role> roleList;
	
	//首页路由
	private String homeRoute;
	
	public UserInfo() {
		roleList = new ArrayList<>();
		permissionList = new ArrayList<>();
	}
	
}
