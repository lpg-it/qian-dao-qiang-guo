<template>
  <div>
    <Header></Header>
    <hr/>
    <div>
      这是首页
    </div>
    <hr/>
    <!-- <blog-footer></blog-footer> -->
  </div>
</template>

<script>
import Header from '@/components/common/Header.vue'
// import blogFooter from '@/components/common/BlogFooter.vue'

export default {
  name: 'Home',
  // blogHeader/blogFooter组件给申明到components里面然后在template里面使用
  components: { Header }
}
</script>