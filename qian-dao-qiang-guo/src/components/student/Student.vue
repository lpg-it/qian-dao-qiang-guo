<template>
  <div>
    <Header/>
    <div class='content'>
这是student
    </div>
  </div>
</template>


<script>
import Header from "@/components/common/Header.vue";
// import blogFooter from '@/components/common/BlogFooter.vue'

export default {
  name: "Student",
  // blogHeader/blogFooter组件给申明到components里面然后在template里面使用
  components: { Header }
};
</script>

<style lang="css" scoped>
.content {
  width: 100%;
  height: 855px;
  background-color: rgb(246, 246, 246);
}
</style>
