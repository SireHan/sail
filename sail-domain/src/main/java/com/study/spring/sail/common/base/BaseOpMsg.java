package com.study.spring.sail.common.base;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 操作结果信息 统一json返回
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
public class BaseOpMsg<T> {
	
	//状态码
	private int code;
	//状态
	private String status;
	//文本信息 （用于显示信息）
	private String msg;
	//返回的单个对象
	private T object;
	//返回的数组对象
	private List<T> list;
	//返回的Map对象
	private Map<String,Object> map;
	
	//详细信息 （用于排查错误）
	private String description;

	public BaseOpMsg(int code, String msg, T object) {
		this.code = code;
		this.msg = msg;
		this.object = object;
	}
	
}
