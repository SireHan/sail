import Vue from "vue";
import VueRouter from "vue-router";
import Vuex from "vuex";
import App from "./app.vue";
import RouterConfig from "./router/router.js";

Vue.use(VueRouter);
Vue.use(Vuex);

const router = new VueRouter(RouterConfig);
router.beforeEach((to, from, next) => {
	if(window.localStorage.getItem('token')){
        window.document.title = to.meta.title;
        next();
	}else{
		next('/login');
	}
})
router.afterEach((to, from, next) => {
	window.scrollTo(0, 0);
})

const store = new Vuex.Store({
	state: {
		count: 0
	},
	mutations: {
		increament (state) {
			state.count ++;
		},
		decrease (state) {
			state.count --;
		}
	},
	getters: {

	},
	actions: {

	},
	modules: {

	}
})

new Vue({
	el: '#app',
	router: router,
    store: store,
	render: h => h(App)
})