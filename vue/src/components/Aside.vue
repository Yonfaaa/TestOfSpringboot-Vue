<template>
    
    <div>
        <el-menu
            style="min-height: calc(100vh - 50px);"
            default-active="user"
            :default-openeds="[1]"
            class="el-menu-vertical-demo"
          >
            <el-sub-menu index="1" >
              <template #title>
                <span style="font-size: large">系统管理</span>
              </template>
              <el-menu-item index="user" :route="{path: '/'}" style="font-size: large">用户管理</el-menu-item>
            </el-sub-menu>
            <el-menu-item index="data" :route="{path: '/'}" style="font-size: large">数据管理</el-menu-item>

          </el-menu>
    </div>
</template>

<script setup>
import {
    Document,
    Menu as IconMenu,
    Location,
    Setting,
} from '@element-plus/icons-vue'


</script>