package com.study.spring.sail.modules.sys.jpaImpl.entity;

import com.study.spring.sail.config.jpa.BaseAuditEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * sys_office 系统机构表
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
@Entity
public class SysOffice extends BaseAuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Long parentId;                                      // 父机构id
    @Column
    private String parentIds;                                   // 上级机构
    @Column(nullable = false, unique = true)
    private String officeName;                                  // 机构名称
    @Column(nullable = false, unique = true)
    private String officeCode;                                  // 机构代码
    @Column(nullable = false)
    private String officeType;                                  // 机构类型
    @Column(nullable = false)
    private Integer officeLevel;                                // 机构层次
    @Column
    private String officePhone;                                 // 机构电话
    @Column
    private String officeEmail;                                 // 机构邮箱
    @Column
    private String officeAddr;                                  // 机构地址
    @Column
    private Long areaId;                                        // 机构地区id
    @Column
    private String jsonInfo;                                    // 其他信息json

}
