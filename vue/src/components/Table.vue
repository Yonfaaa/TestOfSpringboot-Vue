<template>
    <el-row>
        <!-- 功能模块 -->
        <div style="margin-left: 0px; margin-right: 20px; padding-top: 0; padding-bottom: 10px;">
            <el-button type="primary" @click="add">新增</el-button>
            <el-button type="primary">导入</el-button>
            <el-button type="primary">导出</el-button>
        </div>
     

        <!-- 查询模块 -->
        <div style="margin-left: 0px; padding-top: 0; padding-bottom: 10px;display: flex;">
            <el-button type="primary" style="margin-right: 20px;" @click="load">查询</el-button>
            <el-input v-model="search" placeholder="请输入关键字" clearable></el-input>
        </div>

    </el-row>
    <el-row>
        <el-table :data="tableData" border style="width: 100%;">
            <el-table-column prop="id" label="ID" sortable/>
            <el-table-column prop="username" label="用户名"  />
            <el-table-column prop="nickName" label="昵称" />
            <el-table-column prop="age" label="年龄" />
            <el-table-column prop="sex" label="性别" />
            <el-table-column prop="address" label="地址" />
            <el-table-column fixed="right" label="操作" width="120">
              <template #default="scope">
                <el-button link type="primary" size="small" @click="handleEdit(scope.row)">编辑</el-button>
                <!-- 防止误操作 -->
                <el-popconfirm title="确认删除吗?" @confirm="handleDelete(scope.row.id)">
                  <template #reference>
                    <el-button type="danger" size="small">删除</el-button>
                  </template>
                </el-popconfirm>
                <!-- <el-button link type="primary" size="small">删除</el-button> -->
              </template>
            </el-table-column>

        </el-table> 
    </el-row>

    <!-- 分页模块 -->
    <el-row>
      <div style="margin: 10px;">
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
        
        <!-- 弹窗模块 -->

        <el-dialog v-model="dialogVisible" title="提示" width="500">
          
          <el-form :model="form" label-width="120px">
            <el-form-item label="用户名">
              <el-input v-model="form.username" style="width: 80%;" />
            </el-form-item>
            <el-form-item label="昵称">
              <el-input v-model="form.nickName" style="width: 80%;" />
            </el-form-item>
            <el-form-item label="年龄">
              <el-input v-model="form.age" style="width: 80%;" />
            </el-form-item>
            <el-form-item label="性别">
              <el-radio v-model="form.sex" value="男">男</el-radio>
              <el-radio v-model="form.sex" value="女">女</el-radio>
              <!-- <el-input v-model="form.sex" style="width: 80%;" /> -->
            </el-form-item>
            <el-form-item label="地址">
              <el-input type="textarea" v-model="form.address" style="width: 80%;" />
            </el-form-item>
          </el-form>

          <template #footer>
            <div class="dialog-footer">
              <el-button @click="dialogVisible = false">取消</el-button>
              <el-button type="primary" @click="save">确定</el-button>
            </div>
          </template>
        </el-dialog>
      </div>
    </el-row>
    
    
</template>
  

<script>
  import { ref } from 'vue'
  import request from '@/utils/request.js'
// import { th, tr } from 'element-plus/es/locale'

  export default {
    components:{

    },
    data(){
      return{
        tableData : [ ],
        dialogVisible: false,
        search:'',
        form:{},
        currentPage4 : ref(1),
        pageSize4 : ref(10),
        small : ref(false),
        background : ref(false),
        disabled : ref(false)
      }
    },
    methods:{
      load(){    //上载数据
        // 这里的参数有点不一样
        request.get("/api/user",
          {
            params:{
              pageNum: this.currentPage4,
              pageSize: this.pageSize4,
              search: this.search
            }
          }
        ).then(res => {
          console.log(res)
          this.tableData=res.data.records //records是后端名
          this.total = res.data.total
        })
      },
      add () {    //添加数据
        this.dialogVisible = true;
        this.form={}
      },
      save(){     //保存数据
        // 调用API接口，port未确定
        if(this.form.id){  //更新
          request.put("/api/user",this.form).then(res => {
            console.log(res)

            if(res.code === '0'){
              this.$message.success("更新成功")
            }
            else{
              this.$message.console.error(res.msg);  //写法不一样，可能报错
            }
            
            this.load()               //刷新表格
            this.dialogVisible=false  //关闭弹窗
          })
        }
        else{              //添加
          request.post("/api/user",this.form).then(res => {
            console.log(res)
            
            if(res.code === '0'){
              this.$message.success("添加成功")
            }
            else{
              this.$message.console.error(res.msg);  //写法不一样，可能报错
            }

            this.load()               //刷新表格
            this.dialogVisible=false  //关闭弹窗
          })
        }
       
      },
      handleEdit (row) {
        this.form = JSON.parse(JSON.stringify(row))
        this.dialogVisible=true
      },
      handleDelete (id) {
        console.log(id)
        request.delete("/api/user" + id).then(res => {
          if(res.code === '0'){
              this.$message.success("删除成功")
            }
            else{
              this.$message.console.error(res.msg);  //写法不一样，可能报错
            }

          this.load()               //刷新表格
          this.dialogVisible=false  //关闭弹窗
        })
      },
      handleSizeChange () {   //可能出现未改变页数的情况
        console.log(`${val} items per page`);
        this.load()
      },
      handleCurrentChange () { //可能出现未改变当前页的情况
        console.log(`current page: ${val}`);
        this.load()
      }
    }
  }
  </script>
  

  