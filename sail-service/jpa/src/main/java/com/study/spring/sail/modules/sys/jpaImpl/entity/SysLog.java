package com.study.spring.sail.modules.sys.jpaImpl.entity;

import com.study.spring.sail.config.jpa.BaseAuditEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * sys_log 系统日志表
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
@Entity
public class SysLog extends BaseAuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private int logType;                                      // 日志类型
    @Column(nullable = false)
    private String logLevel;                                  // 日志级别
    @Column(nullable = false)
    private String logTitle;                                  // 日志标题
    @Column
    private String logContent;                               // 日志内容
    @Column
    private String jsonInfo;                                 // 其他信息json

}
