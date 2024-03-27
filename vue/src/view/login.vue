<script>
import {Sunny, User} from "@element-plus/icons-vue";
import request from "@/utils/request.js";
import {useRouter} from "vue-router";
import { ElMessage } from 'element-plus'

// 全局注册的方法
const showMessage = (type, message) => {
  ElMessage({
    type: type,
    message: message
  })
}

export default {
  name:'login',
  components: {Sunny, User},
  data(){
    return{
      form:{
        username:'',
        password:''
      },
      rules:{
        username:[
          {required: true, message:"请输入用户名",trigger:"blur"},
        ],
        password:[
          {required: true, message:"请输入密码",trigger:"blur"},
        ],
      }
    }
  },

  // 这个是vue3的新特性，钩子方法
  setup(){
    const router=useRouter()
    const login = (form) => {
      request.post("/user/login",form).then(res => {
        if(res.code == 0){
          showMessage("success","登录成功")
          router.push('/home')
        }
        else{
          showMessage("error",res.msg)
          // gotoHome()
        }
      })
      // this.$refs['form'].validate((valid)=>{
      //   if (valid){
      //
      //   }
      // })

      // request.post("/user/login",form).then(res => {
      //   if(res.code == 0){
      //     showMessage(q"success","登录成功")
      //     router.push('/home')
      //   }
      //   else{
      //     showMessage("error",res.msg)
      //     // gotoHome()
      //   }
      // })
    }
    return {
      login
    }
  },

}
</script>

<template>
  <div class="login-container" style="width: 100%;height: 100vh;overflow: hidden">
      <div style="width: 400px; margin: 150px auto">
        <div style="color: #cccccc;font-size: 30px; text-align: center; padding:30px 0px" >欢迎登陆</div>
        <el-form ref="form" :model="form" size="default" :rules="rules">
<!--          用户名-->
          <el-form-item prop="username">
            <el-input v-model="form.username">
              <template #prefix>
                <el-icon><User /></el-icon>
              </template>
            </el-input>
          </el-form-item>
<!--          密码-->
          <el-form-item prop="password">
            <el-input v-model="form.password" show-password>
              <template #prefix>
                <el-icon><Sunny /></el-icon>
              </template>
            </el-input>
          </el-form-item>

          <el-form-item>
            <el-button style="width: 100%" type="primary" @click="login(form)">登陆</el-button>
          </el-form-item>
        </el-form>
      </div>
  </div>
</template>

<style>
.login-container{
  background-image: url("@/assets/background.jpg");
}
</style>