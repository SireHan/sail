import axios from 'axios';
import qs from 'qs';

const Request = {
    apiPath: 'http://127.0.0.1:8100/',
}
// ajax 通用配置
Request.ajax = axios.create({
    baseURL:Request.apiPath,
    timeout: 1000,
    withCredentials: true, // 每次请求携带cookies信息
    headers:{
        'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'
    },
    transformResponse: [function (data) {
        // 可以对data做任何操作
        return  qs.stringify(data);;
    }],
    transformRequest: [function (data, headers) {
        // 请求参数处理
        return qs.stringify(data);
    }]
})
// 添加请求拦截器
/*axios.interceptors.request.use(function (config) {
    // Do something before request is sent
    return config;
}, function (error) {
    // Do something with request error
    return Promise.reject(error);
});*/
// 添加响应拦截器
Request.ajax.interceptors.response.use(res => {
    return res.data;
});

export default Request;
