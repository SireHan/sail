import Vue from "vue";
import VueRouter from "vue-router";
import App from "./app.vue";
import RouterConfig from "./router/router.js";

Vue.use(VueRouter);
const router = new VueRouter(RouterConfig);
new Vue({
	el: '#app',
	router: router,
	render: h => h(App)
})