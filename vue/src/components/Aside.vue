<template>

    <div>
        <el-menu
            style="min-height: calc(100vh - 50px);"
            default-active="user"
            :default-openeds="[1]"
            :default-active="$route.path"
            router
            class="el-menu-vertical-demo" >
<!--            @open="handleOpen"-->
<!--            @close="handleClose"-->

            <el-menu-item index="home" style="font-size: large" type="primary">
              <span slot="title">用户管理</span>
            </el-menu-item>

            <el-menu-item index="data" style="font-size: large" type="primary">
              <span slot="title">图书管理</span>
            </el-menu-item>

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