// import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'

import "@/assets/css/global.css"


// 配置路由
import {createRouter,createWebHistory} from 'vue-router'
import Layout from "@/Layout/Layout.vue";
import Table from "@/components/Table.vue";
import Book from "@/components/Book.vue";


const routes = [
    {
        path: '/',
        name: 'Layout',
        component: Layout,
        redirect:"/home",   //自动跳转到所示路径
        children: [
            //用户管理
            {
            path:'home',
            name: 'Home',
            component: Table,
            },
            //图书管理
            {
                path:'data',
                name:'Book',
                component:Book,
            }
        ],

    },
    {
        path: '/login',
        name: 'login',
        component: () => import("@/view/login.vue")
    },
    {
        path: '/register',
        name: 'Register',
        component: () => import("@/view/Register.vue")
    },
], router = createRouter({
    history: createWebHistory(),
    routes
}), app = createApp(App);

app.use(ElementPlus,{locale: zhCn,})
app.use(router)
app.mount('#app')




