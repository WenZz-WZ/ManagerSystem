import Vue from "vue";
import Vuex from 'vuex';


Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        routes: []
    },

    mutations: {
        initRoutes (state, data) {
            state.routes = data

        },

    }
})

// store.watch(function (state) {
//     return state.sessions
// }, function (val) {
//     console.log('CHANGE: ', val);
//     localStorage.setItem('vue-chat-session', JSON.stringify(val));
// }, {
//     deep: true/*这个貌似是开启watch监测的判断,官方说明也比较模糊*/
// })

export default store;