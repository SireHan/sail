package com.study.spring.sail.modules.sys.domain;

import com.study.spring.sail.common.base.BaseEntity;
import lombok.Data;

/**
 * 系统信息 角色信息
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String roleName;                                        // 角色名称
    private String roleEname;                                       // 英文名称
    private String roleType;                                        // 角色类型
    private String roleStatus;                                      // 角色状态

}
