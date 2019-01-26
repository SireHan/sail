package com.study.spring.sail.modules.sys.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统信息 用户信息 + 账户信息
 *
 * @author 韩炜
 * @date 2019-01-15 11:00
 */
@Data
public class LoginInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Login login;                // 账户信息
    private Long userId;                // 用户信息

}
