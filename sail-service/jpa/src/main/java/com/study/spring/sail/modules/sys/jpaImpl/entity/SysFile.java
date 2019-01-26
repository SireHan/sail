package com.study.spring.sail.modules.sys.jpaImpl.entity;

import com.study.spring.sail.config.jpa.BaseAuditEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * sys_file 系统文件表
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
@Entity
public class SysFile extends BaseAuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String fileFrom;                                // 文件来源
    @Column(nullable = false)
    private String fileName;                                // 文件名称
    @Column(nullable = false)
    private String fileSize;                                // 文件大小
    @Column(nullable = false)
    private String fileType;                                // 文件类型
    @Column
    private String location;                                // 文件相对地址
    @Column
    private String url;                                     // 文件相对访问地址
    @Column
    private String store;                                   // 文件存储位置
    @Column
    private String ip;                                      // 存贮ip

}
