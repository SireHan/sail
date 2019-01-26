package com.study.spring.sail.modules.sys.jpaImpl.entity;

import com.study.spring.sail.config.jpa.BaseAuditEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * sys_area 系统地区表
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
@Entity
public class SysArea extends BaseAuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long parentId;                                      // 父机构id
    @Column
    private String parentIds;                                   // 上级地区
    @Column(nullable = false)
    private String areaName;                                    // 地区名称
    @Column(nullable = false, unique = true)
    private String areaCode;                                    // 地区代码
    @Column(nullable = false)
    private String areaType;                                    // 地区类型
    @Column(nullable = false)
    private Integer areaLevel;                                  // 地区层次
    @Column
    private String jsonInfo;                                    // 其他信息json

}
