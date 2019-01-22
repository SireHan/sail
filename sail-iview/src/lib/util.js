import axios from 'axios';

const Util = {
    apiPath: 'http://127.0.0.1:8100/',
    imgPath: 'http://127.0.0.1:8011/img/'
}
// ajax 通用配置
Util.ajax = axios.create({
    baseURL:Util.apiPath
})
// 添加响应拦截器
Util.ajax.interceptors.response.use(res => {
    return res.data;
});

export default Util;
