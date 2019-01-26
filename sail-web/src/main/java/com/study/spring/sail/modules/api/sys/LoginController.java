package com.study.spring.sail.modules.api.sys;

import com.study.spring.sail.common.base.BaseOpMsg;
import com.study.spring.sail.common.status.StatusCode;
import com.study.spring.sail.modules.sys.domain.UserInfo;
import com.study.spring.sail.modules.sys.service.LoginInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * city API
 *
 * @author 韩炜
 * @date 2019-01-14 9:54
 */
@RestController
@RequestMapping("/api/sys")
public class LoginController {

    @Autowired
    private LoginInfoService loginInfoService;

    @ApiOperation(value = "登录验证", notes = "验证用户是否登录")
    @GetMapping("/loginValidator")
    public BaseOpMsg<Object> loginValidator() {
        BaseOpMsg<Object> result = new BaseOpMsg<>();
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof UserDetails) {
                String username = ((UserDetails) principal).getUsername();
                result.setCode(StatusCode.RES_SUCCESS);
                result.setMsg("session未超时");
                result.setObject(true);
            } else {
                String username = principal.toString();
                result.setCode(StatusCode.RES_FAILURE);
                result.setMsg("session超时");
                result.setObject(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(StatusCode.RES_FAILURE);
            result.setMsg("session超时");
            result.setObject(false);
        }
        return result;
    }

    @ApiOperation(value = "登录账户信息", notes = "获取账户所有信息")
    @ApiImplicitParam(name = "loginName", value = "父行政区划id", paramType = "query", dataType = "Long")
    @PostMapping(value = "/userInfo")
    public BaseOpMsg<UserInfo> getUserInfo(String loginName) {
        BaseOpMsg<UserInfo> result = new BaseOpMsg<>();
        UserInfo userInfo = loginInfoService.getUserInfo(loginName);
        if (userInfo != null) {
            result.setCode(StatusCode.RES_SUCCESS);
            result.setMsg("信息获取成功");
            result.setObject(userInfo);
        } else {
            result.setCode(StatusCode.RES_FAILURE);
            result.setMsg("信息获取失败");
            result.setObject(null);
        }
        return result;
    }
}
