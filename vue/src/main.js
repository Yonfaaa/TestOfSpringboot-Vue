// import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'

import "@/assets/css/global.css"

createApp(App).use(ElementPlus,{locale: zhCn,}).mount('#app')
