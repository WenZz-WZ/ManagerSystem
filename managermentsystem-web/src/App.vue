<template>
  <div id="app">
<!--    <div id="nav">-->
<!--      <router-link to="/">Home</router-link> |-->
<!--    </div>-->
    <router-view/>
  </div>
</template>


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
  border-radius: 10px !important;
  min-width: 0 !important;
}
.el-menu-item, .el-submenu__title {
  margin: 0 4px;
  height: 40px !important;
  line-height: 35px !important;
}
.el-menu-item-group__title{
  padding: 0 !important;
}
.el-menu-item, .el-submenu__title{
  padding-left: 16px !important;
}



</style>
