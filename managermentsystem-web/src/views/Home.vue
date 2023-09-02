<template>
  <div>
    <el-container>
      <el-aside :width="asideWidth" style="background-color: #001529; min-height: 100vh; box-shadow: 2px 0 6px rgba(0,21,41,.35)">
        <div style="display: flex; justify-content: center; align-items: center; height: 10%">
          <img src="@/assets/logo1.png" style="width: 40px; height: 40px">
          <span v-show="!isCollapse" style="color: white; padding-left: 5px">XXX管理系统</span>
        </div>
        <!--菜单-->
        <el-menu
            :default-active="$route.path"
            router
            background-color="#001529"
            text-color="rgba(255, 255, 255, 0.65)"
            :collapse="isCollapse"
            :collapse-transition="true"
            active-text-color="#fff"
            style="border: none"
        >
          <el-menu-item index="/home">
            <i class="el-icon-location"></i>
            <span>首页</span>
          </el-menu-item>
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>导航一</span>
            </template>
            <el-menu-item index="/test">选项1</el-menu-item>
            <el-menu-item index="1-2">选项2</el-menu-item>
          </el-submenu>
          <el-menu-item index="/test">
            <i class="el-icon-menu"></i>
            <span slot="title">导航二</span>
          </el-menu-item>
        </el-menu>
      </el-aside>

      <el-container>
        <!--头部-->
        <el-header style=" display: flex; align-items: center; justify-content: space-between; box-shadow: 2px 0 6px rgba(0,21,41,.35)">
          <div style="display: flex; align-items: center">
            <i :class="[ this.isCollapse === false ? 'el-icon-s-fold' : 'el-icon-s-unfold']" style="font-size: 26px"
               @click="showMenu"></i>
            <el-breadcrumb separator="/" style="padding-left: 5px">
              <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>
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
      isCollapse: false,
      asideWidth: '200px',
    }
  },
  mounted() {
    console.log(this.$route)
  },
  methods: {
    showMenu() {
      console.log(this.isCollapse)
      if (this.isCollapse) {
        this.isCollapse = false
        this.asideWidth = '200px'
      } else {
        this.isCollapse = true
        this.asideWidth = 'auto'

      }


    }
  }

}
</script>


<style>
.el-menu--inline .el-menu-item {
  background-color: #000c17 !important;
}
.el-menu-item:hover, .el-submenu__title:hover {
  color: white !important;
}
.el-menu-item:hover i, .el-submenu__title:hover i {
  color: white !important;
}
.el-menu-item.is-active {
  background-color: #1890ff !important;
  border-radius: 10px;
  margin: 0 4px;
}
.el-menu-item, .el-submenu__title {
  margin: 0 4px;
}
.el-menu-item, .el-submenu__title{
  height: 40px !important;
  line-height: 35px !important;
}
</style>