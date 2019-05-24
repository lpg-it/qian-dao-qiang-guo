<template>
  <div>
    <Header/>
    <div class="content">
      <div class="breadcrumb">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item :to="{path: '/role'}">角色管理</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
    </div>
  </div>
</template>


<script>
import Header from "@/components/common/Header.vue";
// import blogFooter from '@/components/common/BlogFooter.vue'

export default {
  name: "Role",
  // blogHeader/blogFooter组件给申明到components里面然后在template里面使用
  components: { Header }
};
</script>

<style lang="css" scoped>
.content {
  display: block;
  /* width: %; */
  height: 855px;
  background-color: rgb(227, 227, 227);
}

/* 面包屑 */
.breadcrumb {
  padding: 18px;
  margin-left: 260px;
}
</style>
