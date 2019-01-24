package com.study.spring.sail.common.status;

/**
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
public class StatusCode {

	// 处理结果状态 成功 失败
	public static final int RES_SUCCESS = 100;
	public static final int RES_FAILURE = 200;

	// 数据状态 正常 删除 审核中
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";

}
