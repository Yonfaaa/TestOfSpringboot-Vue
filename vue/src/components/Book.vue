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
      <el-input v-model="search" placeholder="请输入关键字" clearable ></el-input>
      <el-button type="primary" style="margin-right: 20px;" @click="load">查询</el-button>
    </div>
  </el-row>
  <el-row>
    <el-col :span="24">
      <el-table :data="tableData" border style="width: 100%;">
        <el-table-column prop="id" label="ID" sortable/>
        <el-table-column prop="name" label="书名"  />
        <el-table-column prop="price" label="价格" />
        <el-table-column prop="author" label="作者" />
        <el-table-column prop="createTime" label="创作时间" />
        <el-table-column prop="cover" label="版本" />
        <el-table-column prop="userId" label="所有者" />
        <el-table-column fixed="right" label="操作" width="120">
          <template #default="scope">
            <el-button link type="primary" size="small" @click="handleEdit(scope.row)">编辑</el-button>
            <!-- 防止误操作 -->
            <el-popconfirm title="确认删除吗?" @confirm="handleDelete(scope.row.id)">
              <template #reference>
                <el-button type="danger" size="small" >删除</el-button>
              </template>
            </el-popconfirm>

          </template>
        </el-table-column>

      </el-table>
    </el-col>
  </el-row>

  <!-- 分页模块 -->
  <el-row>
    <el-col :span="24">
      <div style="margin: 10px;">
        <el-pagination
            v-model:current-page="currentPage4"
            v-model:page-size="pageSize4"
            :page-sizes="[5, 10, 20]"
            :small="small"
            :disabled="disabled"
            :background="background"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
        />

        <!-- 弹窗模块 -->

        <el-dialog v-model="dialogVisible" title="提示" width="500">

          <el-form :model="form" label-width="120px">
            <el-form-item label="书名">
              <el-input v-model="form.name" style="width: 80%;" />
            </el-form-item>
            <el-form-item label="价格">
              <el-input v-model="form.price" style="width: 80%;" />
            </el-form-item>
            <el-form-item label="作者">
              <el-input v-model="form.author" style="width: 80%;" />
            </el-form-item>
            <el-form-item label="版本">
              <el-input v-model="form.cover" style="width: 80%;" />
            </el-form-item>
            <el-form-item label="创作日期">
              <el-date-picker
                  v-model="form.createTime"
                  type="date"
                  placeholder="选择日期">
              </el-date-picker>
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
    </el-col>
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
      total:0,
      currentPage4 : ref(1),
      pageSize4 : ref(10),
      small : ref(false),
      background : ref(false),
      disabled : ref(false)
    }
  },
  created() {
    this.load()
  },
  methods:{
    load(){    //上载数据
      // 这里的参数有点不一样
      request.get("/book",
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
        request.put("/book",this.form).then(res => {
          console.log(res)
          if(res.code === 0){
            this.$message({
              type:"success",
              message:"更新成功"
            })
          }
          else{
            this.$message({
              type:"error",
              message:res.msg
            })
          }

          this.load()               //刷新表格
          this.dialogVisible=false  //关闭弹窗
        })
      }
      else{              //添加
        request.post("/book",this.form).then(res => {
          console.log(res)

          if(res.code === 0){
            this.$message({
              type:"success",
              message:"添加成功"
            })
          }
          else{
            this.$message({
              type:"error",
              message:res.msg
            })
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
      request.delete("/book/" + id).then(res => {
        if(res.code === 0){
          this.$message({
            type:"success",
            message:"删除成功"
          })
        }
        else{
          this.$message({
            type:"error",
            message:res.msg
          })
        }

        this.load()               //刷新表格
        this.dialogVisible=false  //关闭弹窗
      })
    },
    handleSizeChange (pageSize4) {
      this.pageSize4=pageSize4
      this.load()
    },
    handleCurrentChange (pageNum) {
      this.currentPage4=pageNum
      this.load()
    }
  }
}
</script>


