import axios from 'axios';
import qs from 'qs';

const Request = {
    apiPath: 'http://127.0.0.1:8100/',
}
// ajax 通用配置
Request.ajax = axios.create({
    baseURL: Request.apiPath,
    timeout: 3000,
    withCredentials: true, // 每次请求携带cookies信息
    crossDomain: true,
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
    },
    transformResponse: [function (data) {
        return qs.stringify(data);
    }],
    transformRequest: [function (data, headers) {
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
Request.ajax.interceptors.response.use(function (response) {
    var data
    // IE9时response.data是undefined，因此需要使用response.request.responseText(Stringify后的字符串)
    if (response.data == undefined || response.data == '') {
        data = response.request.responseText
    } else {
        data = response.data
    }
    // 判断data不是Object时，解析成Object
    if (!(data instanceof Object)) {
        data = JSON.parse(data)
    }
    return data
}, function (error) {
    return Promise.reject(error)
});

export default Request;
