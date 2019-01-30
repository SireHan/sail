package com.study.spring.sail.common.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * Entity支持类
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    public static final String DEL_FLAG_AUDIT = "2";

    /**
     * 禁用标记（0：开启；1：禁用）
     */
    public static final String START_STATUS = "0";
    public static final String DISABLE_STATUS = "1";

    public static final Boolean YES = true;
    public static final Boolean NO = false;

    protected String remarks; // 备注
    protected Long createBy; // 创建者
    protected Date createDate;// 创建日期
    protected Long updateBy; // 更新者
    protected Date updateDate;// 更新日期
    protected String delFlag; // 删除标记
}
