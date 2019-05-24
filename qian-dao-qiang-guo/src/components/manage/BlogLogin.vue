<template>
  <div>
    <blog-header></blog-header>
    <hr>
    <div>
      用户名:
      <input type="text" v-model="User.id" placeholder="请输入用户名">
      <br>密码：
      <input type="password" v-model="User.password" placeholder="请输入密码">
      <br>
      <button v-on:click="login">登录</button>
      <br>登录验证情况：
      <textarea cols="30" rows="10" v-model="responseResult"></textarea>
    </div>
    <hr>
    <!-- <blog-footer></blog-footer> -->
  </div>
</template>

<script>
import blogHeader from "@/components/common/BlogHeader.vue";
// import blogFooter from "@/components/common/BlogFooter.vue";

export default {
  name: "BlogLogin",
  // blogHeader、blogFooter组件给申明到components里面然后在template里面使用
  components: { blogHeader },
  data() {
    return {
      User: { id: "", password: "" },
      responseResult: []
    };
  },
  methods: {
    login() {
      this.$axios
        .post("/SSM/api/login", {
          id: this.User.id,
          password: this.User.password
        })
        .then(successResponse => {
          console.log(successResponse.data);
          this.responseResult = JSON.stringify(successResponse.data);
          if (successResponse.data.code == 200) {
            this.$router.replace({ path: "/index" });
          }
        })
        .catch(failResponse => {});
    }
  }
};
</script>