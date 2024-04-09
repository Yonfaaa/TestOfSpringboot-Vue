<template>


  <el-menu
      style="min-height:calc(100vh - 50px);"
      active-text-color="#ffd04b"
      background-color="#545c64"
      class="nav"
      default-active="user"
      :default-openeds="[1]"
      :default-active="$route.path"
      router
      text-color="#fff"
  >

      <el-menu-item class="icon">
        <div class="icon-img"><img src="/head.jpg" alt=""></div>
        <div class="icon-con">
          <p>Good Day</p>
          <h2>Vitality D.</h2>
        </div>
      </el-menu-item>

      <div class="line"></div>
      <div class="title">
        <p>menu</p>
      </div>
      <div class="menu">
        <el-menu-item class="item" index="home" type="primary">
          <el-icon><icon-menu /></el-icon>
          <span class="con">User Management</span>
        </el-menu-item>
        <el-menu-item class="item" index="data" type="primary">
          <el-icon><Share /></el-icon>
          <span class="con">Data Management</span>
        </el-menu-item>
      </div>

      <div class="line"></div>
      <div class="title">
        <p>serve</p>
      </div>

      <div class="setting">
        <el-menu-item class="item" index="2" type="primary">
          <el-icon><icon-menu /></el-icon>
          <span class="con">Navigator Two</span>
        </el-menu-item>
        <el-menu-item class="item" index="2" type="primary">
          <el-icon><Share /></el-icon>
          <span class="con">Navigator Two</span>
        </el-menu-item>
      </div>

  </el-menu>

</template>

<script setup>
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting, Share, Menu,
} from '@element-plus/icons-vue'


</script>

<style>
  p{
    color:rgba(255,255,255);
  }

  .nav{
    width: 110px;
    border-radius: 20px;
    overflow: hidden;
    transition: 0.5s;
  }
  .nav:hover{
    width: 280px;
  }
  .icon{
    width: 250px;
    height: 60px;
    margin-left: 5px;
    margin-top: 20px;
    display: flex;
  }
  .icon-img{
    width: 60px;
    height: 60px;
    border-radius: 50%;
    border: 4px solid rgba(255,255,255,0.3);
    overflow: hidden;
  }
  .icon-img img{
    width: 100%;
    height: 100%;
    border-radius: 50%;
    object-fit: cover;
  }
  .icon-con{
    display: flex;
    flex-direction: column;
    height: 60px;
    margin-left: 25px;
  }
  .icon-con p{
    height: 30%;
  }
  .icon-con h2{
    font-weight: 400;
    height: 70%;
  }
  .line{
    width: 60px;
    height: 1px;
    background: rgba(245,253,255,0.5);
    margin: 20px 25px;
    transition: 0.5s;
  }
  .nav:hover .line{
    width: 230px;
  }
  .title{
    width: 60px;
    margin-left: 25px;
    margin-bottom: 20px;
  }
  .title p{
    font-size: 18px;
    margin-left: 5px;
  }
  .menu{
    width: 230px;
    margin-left: 20px;
  }
  .setting{
    width: 230px;
    margin-left: 20px;
  }
  .item{
    transition: 0.5s;
    border-radius: 6px;
  }
  .item:hover{
    background: rgba(255,255,255,0.1);
  }
  .con{
    width: 0;
    transition: 0.5s;
    overflow: hidden;
    opacity: 0;
  }
  .nav:hover .con{
    width: 160px;
    opacity: 1;
  }


</style>