<script>
import {Sunny, Sunrise, User} from "@element-plus/icons-vue";
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
  name:'register',
  components: {Sunrise, Sunny, User},
  data(){
    return{
      form:{
        username:'',
        password:'',
        confirm:''
      },
      rules:{
        username:[
          {required: true, message:"请输入用户名",trigger:"blur"},
        ],
        password:[
          {required: true, message:"请输入密码",trigger:"blur"},
        ],
        confirm:[
          {required: true, message:"请确认密码",trigger:"blur"},
        ],
      }
    }
  },
  // 这个是vue3的新特性，钩子方法
  setup(){
    const router = useRouter()
    // const gotoLogin=()=>{
    //   router.push('/home')
    //
    //
    // }
    const register = (form) => {
      // 判断两次密码输入是否一致
      if(form.password !== form.confirm){
        showMessage("error","两次密码输入不一致！")
        return
      }

      request.post("/user/register",form).then(res => {
        console.log(res.code)
        if(res.code ==  0){
          showMessage("success","注册成功")
          router.push('/login')
        }
        else{
          showMessage("111",res.msg)
          // router.push('/login')

        }
      })
      // this.$refs['form'].validate((valid)=> {
      //   if (valid) {
      //
      //   }
      // })

    }
    return {
      register
    }
  },

}
</script>

<template>
  <div class="login-container" style="width: 100%;height: 100vh;overflow: hidden">
    <div style="width: 400px; margin: 150px auto">
      <div style="color: #cccccc;font-size: 30px; text-align: center; padding:30px 0px" >欢迎注册</div>
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
            <router-link to="/"></router-link>
            <template #prefix>
              <el-icon><Sunny /></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <!--        确认密码-->
        <el-form-item prop="confirm">
          <el-input v-model="form.confirm" show-password>
            <template #prefix>
              <el-icon><Sunrise /></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <!--        提交按钮-->
        <el-form-item>
          <el-button style="width: 100%" type="primary" @click="register(form)">注册</el-button>
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