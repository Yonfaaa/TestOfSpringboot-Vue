<template>
    <el-row>
        <!-- 功能模块 -->
        <div style="margin-left: 0px; margin-right: 20px; padding-top: 0; padding-bottom: 10px;">
            <el-button type="primary">新增</el-button>
            <el-button type="primary">导入</el-button>
            <el-button type="primary">导出</el-button>
        </div>
     

        <!-- 查询模块 -->
        <div style="margin-left: 0px; padding-top: 0; padding-bottom: 10px;display: flex;">
            <el-button type="primary" style="margin-right: 20px;">搜索</el-button>
            <el-input v-model="search" placeholder="请输入关键字"></el-input>
        </div>

    </el-row>
    <el-row>
        <el-table :data="tableData" border style="width: 100%;">
            <el-table-column prop="date" label="Date" sortable/>
            <el-table-column prop="name" label="Name"  />
            <el-table-column prop="address" label="Address" />
            <el-table-column fixed="right" label="Operations" width="120">
              <template #default>
                <el-button link type="primary" size="small" @click="handleClick">编辑</el-button>
                <!-- 防止误操作 -->
                <el-popconfirm title="确认删除吗?">
                  <template #reference>
                    <el-button type="text" size="small">删除</el-button>
                  </template>
                </el-popconfirm>
                <!-- <el-button link type="primary" size="small">删除</el-button> -->
              </template>
            </el-table-column>

        </el-table> 
    </el-row>
    <el-row>
      <div>
        <el-pagination
          v-model:current-page="currentPage4"
          v-model:page-size="pageSize4"
          :page-sizes="[5, 10, 20]"
          :small="small"
          :disabled="disabled"
          :background="background"
          layout="total, sizes, prev, pager, next, jumper"
          :total="40"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
        />
      </div>
    </el-row>
    
    
</template>
  

<script setup>

  const handleClick = () => {
    console.log('click')
  }

  const search=''

  const tableData = [
    {
      date: '2023-10-01',
      name: '椿襄',
      address: '国软坡土著，dps',
    },
    {
      date: '2023-10-01',
      name: '太阳王路易',
      address: '国软坡土著，tank',
    },
    {
      date: '2023-10-01',
      name: '惊艳的路灯花',
      address: '国软坡土著，sup',
    },
    {
      date: '2023-10-01',
      name: '茶味饮料',
      address: '国软坡土著，dps',
    },
  ]

  import { ref } from 'vue'
  
  const currentPage4 = ref(1)
  const pageSize4 = ref(10)
  const small = ref(false)
  const background = ref(false)
  const disabled = ref(false)

  const handleSizeChange = function(val) {
    console.log(`${val} items per page`);
  }

  const handleCurrentChange = function(val) {
    console.log(`current page: ${val}`);
  }

  </script>
  