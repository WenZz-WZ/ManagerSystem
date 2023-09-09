import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import request from '@/utils/request.js';
import {initMenus} from "./utils/menu";
import store from "./store";


Vue.config.productionTip = false
Vue.use(ElementUI, {size: 'mini'});
Vue.prototype.$request = request

let hasRoles = true
router.beforeEach( (to, from, next) => {

  // 路由添加进去了没有及时更新 需要重新进去一次拦截
  if (hasRoles) {
    initMenus(router, store)
    hasRoles = false
    next({...to, replace: true})

  }

  next()
})

new Vue({
  router,
  store: store,
  render: h => h(App)
}).$mount('#app')
