<template>
  <div style="background-color: #3CB371 ; height: 100vh; display: flex; align-items: center; justify-content: center">
    <div
        style="width: 50%; display: flex; background-color: white; border-radius: 15px; overflow: hidden; box-shadow: 0 0 25px #3CB371;">
      <div style="flex: 1">
        <img src="@/assets/login.png" style="width: 100%"/>
      </div>
      <div style="flex: 1; display: flex; align-items: center; justify-content: center; width: 100%">
        <el-form label-width="60px" :rules="rules" ref="loginForm" :model="loginForm">
          <h3 style="display: flex; justify-content: center; padding-bottom: 15px">后台管理系统</h3>
          <el-form-item label="账号" prop="username">
            <el-input v-model="loginForm.username" @keyup.enter.native="login"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="loginForm.password" @keyup.enter.native="login"></el-input>
          </el-form-item>
          <el-checkbox class="loginRemember">记住我</el-checkbox>
          <el-button type="primary" @click="login" style="width: 100%" >登录</el-button>
        </el-form>

      </div>

    </div>
  </div>
</template>


<script>


export default {
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      rules: {
        username: [{ required: true, message: '请输入用户名', trigger: 'blur'}],
        password: [{ required: true, message: '请输入密码', trigger: 'blur'}]
      }
    }
  },
  methods: {
    login() {
      this.$refs['loginForm'].validate( valid => {
        if (valid) {
          this.$request.post('/login', this.loginForm).then(res => {
            if (res.code === '200') {
              console.log(res)
              this.$message.success('登录成功')
              this.$router.replace('Home')

            } else {
              this.$message.error(res.msg)
            }
          })
        }
      })
    }
  }
}

</script>

<style>
.loginRemember {
  text-align: left;
  margin: 0px 0px 15px 15px;
}
</style>
