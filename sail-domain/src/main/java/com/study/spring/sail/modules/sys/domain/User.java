package com.study.spring.sail.modules.sys.domain;

import com.study.spring.sail.common.base.BaseEntity;
import lombok.Data;

/**
 * 系统信息 用户信息
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;                                // 姓名
    private String sex;                                 // 性别
    private String idCard;                             // 身份标识
    private String userType;                           // 用户类型
    private String userStatus;                         // 用户状态
    private Long orgId;                                 // 机构id
    private Long areaId;                                // 地区id
    private String jsonInfo;                           // 其他信息json

}
