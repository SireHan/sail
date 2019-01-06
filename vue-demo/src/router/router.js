const Routers = [
    {
        path: '/index',
        component: (resolve) => require(['../views/index.vue'],resolve)
    },
    {
        path: '/user/:userId',
        component: (resolve) => require(['../views/index.vue'],resolve)
    },
    {
        path: '/about',
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