const Routers = [
    {
        path: '/index',
        meta: {
            title: '首页'
        },
        component: (resolve) => require(['../views/index.vue'],resolve)
    },
    {
        path: '/user/:userId',
        meta: {
            title: '我的'
        },
        component: (resolve) => require(['../views/index.vue'],resolve)
    },
    {
        path: '/about',
        meta: {
            title: '关于'
        },
        component: (resolve) => require(['../views/about.vue'],resolve)
    },
    {
        path: '*',
        redirect: '/index'
    }
]

const RouterConfig = {
    mode: 'history',
    routes: Routers
}

export default RouterConfig;