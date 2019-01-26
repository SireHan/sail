import $ from '@/lib/request';

/**
 * @Param 账户名 密码
 * @description 登录接口
 */
export const login = ({loginName, password}) => {
    const data = {
        username: loginName,
        password
    }
    return $.ajax.post('api/sys/login', data)
}

/**
 * @Param 账户名
 * @description 获取账户信息接口
 */
export const getUserInfo = (loginName) => {
    const data = {
        loginName
    }
    return $.ajax.post('api/sys/userInfo', data)
}

/**
 * @description 验证登录状态接口
 */
export const loginValidator = () => {
    return $.ajax.get('api/sys/loginValidator')
}

