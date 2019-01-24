import {login,getUserInfo} from "@/api/module/user";
import {setToken} from "@/lib/util";

export default {
    state: {
        loginName: '',
        userId: '',
        roleId: '',
        officeId: '',
        token: ''
    },
    mutations:{
        setToken (state, token) {
            state.token = token
            setToken(token)
        },
        setLoginName (state, loginName) {
            state.loginName = loginName
        },
        setUserId (state, userId) {
            state.userId = userId
        },
    },
    actions:{
        // 登录
        handleLogin({ commit }, {loginName, password}){
            loginName = loginName.trim()
            return new Promise((resolve, reject) => {
                login({loginName, password})
                    .then(data => {
                        commit('setToken', data.token)
                        resolve()
                    }).catch(err =>{
                        reject(err);
                    })
            })
        },
        // 获取用户信息
        updateUserInfo({ state, commit }){
            return new Promise((resolve, reject) => {
                try {
                    getUserInfo(state.token).then(data => {
                        commit('setLoginName', data.loginName)
                        commit('setUserId', data.userId)
                        resolve(data)
                    }).catch(err => {
                        reject(err)
                    })
                } catch (error) {
                    reject(error)
                }
            })
        }
    }
}