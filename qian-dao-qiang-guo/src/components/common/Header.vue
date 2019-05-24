<template>
  <div>
    <el-container>
      <el-header height="80px">
        <div class="header">
          <div class="nav-left">
            <span>签 到 强 国</span>
          </div>
          <!-- <div class="nav-center">
            <ul>
              <li v-for="(nav,i) in navlinks" :key="nav.id">
                <router-link :to="{name:nav.name}">{{ nav.title }}</router-link>
              </li>
            </ul>
          </div>-->

          <!-- <el-dropdown> -->
          <div class="nav-right" @mouseenter = 'enterHandler' @mouseleave = 'leaveHandler' >
                  <span class="user">admin</span>
                  <ul class="my_account" v-show = 'isShow'>
                      <li @click='quit'>
                       退出
                        <i>></i>
                      </li>
                  </ul>
          </div>

          <!-- </div> -->
        </div>
      </el-header>
    </el-container>
    <el-col :span="3">
      <el-menu default-active="2" class="el-menu-vertical-demo">
        <el-menu-item default-active="nav.id" v-for="(nav,i) in navlinks" :key="nav.id">
          <i class="el-icon-menu"></i>
          <router-link :to="{name:nav.name}">{{ nav.title }}</router-link>
        </el-menu-item>
      </el-menu>
    </el-col>
  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      isShow: false,
      navlinks: [
        { id: 1, title: "首页", name: "Home" },
        { id: 2, title: "签到管理", name: "Register" },
        { id: 3, title: "学生管理", name: "Student" },
        { id: 4, title: "教师管理", name: "Teacher" },
        { id: 5, title: "课程管理", name: "Course" },
        { id: 6, title: "角色管理", name: "Role" },
      ]
    };
  },
  methods: {
    quit(){
      this.$router.replace({ path: "/login" });
    },
    enterHandler() {
      this.isShow = true;
    },
    leaveHandler() {
      this.isShow = false;
    }
  },
  created() {
    console.log("导航组件加载了");
  }
  // computed:{
  //   userInfo(){
  //     console.log(this.$store.state.userinfo);
  //     // let userInfo = {
  //     //   access_token:this.$cookies.get('access_token'),
  //     //   notice_num:this.$cookies.get('notice_num'),
  //     //   shop_cart_num:this.$cookies.get('shop_cart_num'),
  //     //   avatar:this.$cookies.get('avatar'),
  //     //   username:this.$cookies.get('username')
  //     // }

  //     return this.$store.state.userinfo
  //   }
  // }
};
</script>

<style lang="css" scoped>
.el-header {
  border-bottom: #c9c9c9;
  box-shadow: 0 0.5px 0.5px 0 #c9c9c9;
}
.header {
  width: 1590px;
  height: 80px;
  line-height: 80px;
  margin: 0 auto 0 50px;
}
.nav-left {
  float: left;
  font-size: 20px;
}
.nav-center {
  float: left;
  margin-left: 100px;
}
.nav-center ul {
  overflow: hidden;
}
.nav-center ul li {
  float: left;
  margin: 0 5px;
  /*width: 100px;*/
  padding: 0 20px;
  height: 80px;
  line-height: 80px;
  text-align: center;
  position: relative;
}
.nav-center ul li a {
  color: #4a4a4a;
  width: 100%;
  height: 60px;
  display: inline-block;
}
.nav-center ul li a:hover {
  color: #b3b3b3;
}
.nav-center ul li a.is-active {
  color: #4a4a4a;
  border-bottom: 4px solid #ffc210;
}

.nav-right {
  float: right;
  position: relative;
  z-index: 100;
}
.nav-right span {
  cursor: pointer;
}
.nav-right .user {
  margin-left: 15px;
}

.nav-right ul {
  position: absolute;
  width: 221px;
  z-index: 100;
  font-size: 12px;
  top: 80px;
  background: #fff;
  border-top: 2px solid #d0d0d0;
  box-shadow: 0 2px 4px 0 #e8e8e8;
}
.nav-right ul li {
  height: 40px;
  color: #4a4a4a;
  padding-left: 30px;
  padding-right: 20px;
  font-size: 12px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  cursor: pointer;
  transition: all 0.2s linear;
}

/* 左边菜单 */
.el-col {
  min-height: 855px;
  background-color: #fff;
  border-right: 2px solid rgb(246, 246, 246);
}
</style>
