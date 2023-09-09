import router from "../router";
import request from "./request";
import Home from "../views/Home.vue";

var getRouter;
export const initMenus = (routers, store) => {
    if (store.state.routes.length > 0) {
        return;
    }
    getRouter = JSON.parse(window.localStorage.getItem('menus'));
    console.log('getRouter',getRouter)
    if (!getRouter) {
        request.get('/menu').then( res => {
            if (res) {
                let routes = getAsyncRoutes(res)
                console.log("routes", routes)
                window.localStorage.setItem('menus', JSON.stringify(res))
                for (let i = 0; i < routes.length; i++) {
                    router.addRoute(routes[i])
                }
                store.commit('initRoutes', routes)
            }
        })
    } else {
        let routes = getAsyncRoutes(getRouter)
        for (let i = 0; i < routes.length; i++) {
            router.addRoute(routes[i])
        }
        store.commit('initRoutes', routes)
    }

}

export function getAsyncRoutes(routes) {
    const res = []
    routes.forEach( route => {
        const children = []
        if (route.children && route.children.length !== 0) {
            route.children.forEach( menu => {
                children.push({
                    path: menu.path,
                    name: menu.name,
                    component(resolve) {
                        if (menu.component.startsWith('Bm')) {
                            require(['@/views/bm/'+ menu.component +'.vue'], resolve)
                        } else if (menu.component.startsWith('Am')) {
                            require(['@/views/am/'+ menu.component +'.vue'], resolve)
                        } else if (menu.component.startsWith('Auth')) {
                            require(['@/views/auth/'+ menu.component +'.vue'], resolve)
                        } else if (menu.component.startsWith('Stu')) {
                            require(['@/views/stu/'+ menu.component +'.vue'], resolve)
                        }
                    }
                })
            })
        }
        res.push({
            path: route.path,
            icon: route.icon,
            name: route.name,
            component: Home,
            children: children
        })
    })
    return res;
}