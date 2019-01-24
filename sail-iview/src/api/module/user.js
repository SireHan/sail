import $ from '@/lib/request';

export const login =({loginName,password}) =>{
    const data = {
        username:loginName,
        password
    }
    return $.ajax.post('api/sys/login',data)
}

export const getUserInfo =(token) =>{
    const data = {
        token
    }
    return $.ajax.post('api/sys/userInfo',data)
}

