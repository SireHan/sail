package com.study.spring.sail.modules.sys.jpaImpl.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * sys_user_office 系统用户机构表
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
@Entity
public class SysUserOffice {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long userId;                                      // 用户id
    @Column(nullable = false)
    private String officeId;                                   // 机构id

}
