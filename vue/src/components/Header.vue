<template>
    <div style="height: 50px; line-height: 50px;border-bottom: 1px solid #ccc;display: flex; ">
        <div style="width: 200px; padding-left: 30px;font-weight: bold;color: dodgerblue; font-size: large">后台管理</div>
        <div style="flex:1"></div>
        <div style="width:100px;">
            <el-dropdown style="text-align: justify;">
                <span class="el-dropdown-link">栖梧
                    <!-- <i class="el-icon-arrow-down el-icon--rights"></i> -->
                    <el-icon class="el-icon--right">
                        <arrow-down />
                    </el-icon>
                </span>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item>个人信息</el-dropdown-item>
                        <el-dropdown-item>退出登录</el-dropdown-item>
                        <!-- <el-dropdown-item>Action 3</el-dropdown-item>
                        <el-dropdown-item disabled>Action 4</el-dropdown-item>
                        <el-dropdown-item divided>Action 5</el-dropdown-item> -->
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>
    </div>
</template>

<script setup>
import { ArrowDown } from '@element-plus/icons-vue'

</script>

<style scoped>
 .example-showcase .el-dropdown-link {
  cursor: pointer;
  color: var(--el-color-primary);
  display: flex;
  align-items: center;
  
  
} 
</style>