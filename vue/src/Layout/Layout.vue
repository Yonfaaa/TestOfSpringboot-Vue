<script>
  import Header from "@/components/Header.vue";
  import Aside from "@/components/Aside.vue";
  import Table from "@/components/Table.vue";

  export default {
    name:"Layout",
    components:{
      Header,
      Aside,
      Table
    }
  }
</script>

<template>
  <div>
<!--头部-->
    <el-container>
      <el-header>
        <Header></Header>
      </el-header>
    </el-container>

    <el-container>
      <!--侧边栏-->
      <el-aside>
        <Aside></Aside>
      </el-aside>

      <el-main>
        <router-view/>
      </el-main>

<!--      <el-main>-->
<!--      &lt;!&ndash;功能模块&ndash;&gt;-->
<!--        <Table/>-->
<!--      </el-main>-->
    </el-container>

  </div>
</template>

<style scoped>

</style>