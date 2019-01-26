import {login, getUserInfo} from "@/api/module/user"
import {setToken} from "@/lib/util"
import config from '@/config'

const {homeName, success, failure} = config

export default {
    state: {
        loginName: '',
        homeName: '',
        // 是否要更新账户信息
        updateInfo: false,
        // 权限列表
        access: [],
        userId: '',
        roleId: '',
        officeId: '',
        token: ''
    },
    mutations: {
        setHomeName(state, homeName) {
            state.homeName = homeName
        },
        setLoginName(state, loginName) {
            state.loginName = loginName
        },
        setUserId(state, userId) {
            state.userId = userId
        },
    },
    actions: {
        // 登录
        handleLogin({commit}, {loginName, password}) {
            loginName = loginName.trim()
            return login({loginName, password})
                .then(res => {
                    if (res.code === success) { // 登录成功
                        // 设置登录信息
                        commit('setLoginName', loginName)
                    } else {
                        // 显示错误信息

                    }
                })
        },
        // 更新用户信息
        updateUserInfo({state, commit}) {
            return getUserInfo(state.loginName)
                .then(res => {
                    const data = res.object
                    commit('setHomeName', data.homeName || homeName)
                    commit('setLoginName', data.login.loginName)
                })
        }
    }
}