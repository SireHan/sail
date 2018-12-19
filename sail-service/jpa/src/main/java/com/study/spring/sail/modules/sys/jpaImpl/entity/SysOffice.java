package com.study.spring.sail.modules.sys.jpaImpl.entity;

import com.study.spring.sail.config.jpa.BaseAuditEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class SysOffice extends BaseAuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = true)
    private Long parentId;                                      // 父机构id
    @Column
    private String parentIds;                                   // 上级机构
    @Column(nullable = false,unique = true)
    private String officeName;                                  // 机构名称
    @Column(nullable = false,unique = true)
    private String officeCode;                                  // 机构代码
    @Column(nullable = false)
    private String officeType;                                  // 机构类型
    @Column(nullable = false)
    private Integer officeLevel;                                // 机构层次
    @Column(nullable = true)
    private String officePhone;                                 // 机构电话
    @Column(nullable = true)
    private String officeEmail;                                 // 机构邮箱
    @Column(nullable = true)
    private String officeAddr;                                  // 机构地址
    @Column(nullable = true)
    private Long areaId;                                        // 机构地区id
    @Column(nullable = true)
    private String jsonInfo;                                    // 其他信息json

}
