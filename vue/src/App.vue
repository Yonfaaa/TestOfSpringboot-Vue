<script>
  import Header from './components/Header.vue';
  import Aside from './components/Aside.vue';
  import Table from './components/Table.vue';

  export default{
    name:"Layout",
    components:{
      Header,
      Aside,
      Table
    }
  }



</script>

<template>
 
    <!-- 头部 -->
    <el-container>
      <el-header>
        <Header></Header>
      </el-header>
    </el-container>
    <el-container>
      <el-aside>
        <Aside></Aside>

      </el-aside>
      <el-main>
        <Table></Table>

      </el-main>
    </el-container>
      
    
    <!-- 主体 -->
    
</template>

<style scoped>

</style>
