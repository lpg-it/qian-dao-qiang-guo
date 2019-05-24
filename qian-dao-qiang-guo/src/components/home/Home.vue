<template>
  <div>
    <Header/>
    <div class="content">
      <div>
        <img :src="welcomeGif" class="welcomeGif">
      </div>
    </div>
  </div>
</template>


<script>
import Header from "@/components/common/Header.vue";
// import blogFooter from '@/components/common/BlogFooter.vue'

export default {
  name: "Home",
  // blogHeader/blogFooter组件给申明到components里面然后在template里面使用
  components: { Header },
  data() {
    return {
      welcomeGif: "../../../static/img/welcome.gif"
    };
  }
};
</script>

<style lang="css" scoped>
.content {
  width: 100%;
  height: 855px;
  background-color: rgb(227, 227, 227);
}

/* 首页欢迎图 */
.welcomeGif {
  display: block;
  width: 45%;
  margin: 0 auto;
}
</style>
