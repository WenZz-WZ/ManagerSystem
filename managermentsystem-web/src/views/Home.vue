<template>
  <div>
    <el-container>
      <el-aside style="background-color: #001529; min-height: 100vh; box-shadow: 2px 0 6px rgba(0,21,41,.35)">
        <!--菜单-->
        <el-menu
            :default-active="$route.path"
            router
            background-color="#001529"
            text-color="rgba(255, 255, 255, 0.65)"
            :collapse="isCollapse"
            :collapse-transition="false"
            active-text-color="#fff"
            unique-opened
            style="border: none"
            class="el-menu-vertical-demo"
        >
          <el-menu-item-group>
            <div style="display: flex; justify-content: center; align-items: center; height: 10%; padding: 10px 0">
              <img src="@/assets/logo1.png" style="width: 40px; height: 40px">
              <span v-show="!isCollapse" style="color: white; padding-left: 5px">XXX管理系统</span>
            </div>
          </el-menu-item-group>
          <el-menu-item index="/home">
            <i class="el-icon-location"></i>
            <span>首页</span>
          </el-menu-item>
          <el-submenu
              :index="index + ''"
              v-for="(item, index) in routes"
              :key="index"
          >
            <template slot="title">
              <i
                  :class="item.icon"
                  style=" margin-right: 5px;"
              ></i>
              <span>{{item.name}}</span>
            </template>
            <el-menu-item-group>
              <el-menu-item
                  :index="children.path"
                  v-for="(children, indexj) in item.children"
                  :key="indexj"
              >{{children.name}}
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <!--头部-->
        <el-header style=" display: flex; align-items: center; justify-content: space-between; box-shadow: 2px 0 6px rgba(0,21,41,.35)">
          <div style="display: flex; align-items: center">

            <!--<el-button @click="showMenu" size="medium" :icon="this.isCollapse ? 'el-icon-s-unfold' :'el-icon-s-fold' "></el-button>-->


            <i :class="[ this.isCollapse === false ? 'el-icon-s-fold' : 'el-icon-s-unfold']" style="font-size: 26px"
               @click="showMenu"></i>
            <el-breadcrumb separator="/" v-if="this.$route.path !== '/home'"  style="padding-left: 5px">
              <el-breadcrumb-item :to="{ path: '/home' }"> 首页 </el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: $route.path}">{{ $route.name }}</el-breadcrumb-item>
            </el-breadcrumb>
          </div>
          <div>
            <el-dropdown>
              <div style="display: flex; align-items: center">
                <img src="@/assets/logo1.png" style="width: 40px"/>
                <span class="el-dropdown-link">管理员</span>
              </div>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item>个人信息</el-dropdown-item>
                <el-dropdown-item>登出</el-dropdown-item>
                <el-dropdown-item>注销</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </el-header>
        <div></div>
        <el-main>
          <div>main</div>
          <router-view></router-view>
        </el-main>
      </el-container>

    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src


export default {
  name: 'Home',
  data() {
    return {
      isCollapse: false
    }
  },
  // 计算属性
  computed: {
    routes () {
      return this.$store.state.routes;
    }
  },
  mounted() {
    console.log('route',this.$route)
  },
  methods: {
    showMenu() {
      this.isCollapse = !this.isCollapse
    }
  }

}
</script>


<style scoped>

.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px !important;
  height: 100% !important;
}
.el-aside{
  width: auto !important;
}



</style>