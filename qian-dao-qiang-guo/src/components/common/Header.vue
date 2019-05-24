<template>
 <el-container>
      <el-header height = '80px' >
            <div class="header">
                <div class="nav-left">
                    <img src="https://www.luffycity.com/static/img/head-logo.a7cedf3.svg" alt="">
                </div>
                <div class="nav-center">
                  	<ul>
                  		<li v-for = '(nav,i) in navlinks' :key="nav.id">
                  			<router-link :to = '{name:nav.name}'>
                  			 {{ nav.title }}
                  			</router-link>
                              <span v-if="i === 2">New</span>
                  		</li>
                  	</ul>
                </div>
            </div>
      </el-header>
    </el-container>


</template>

<script>
export default {

  name: 'Header',
  data(){
      return {
          isShow:false,
          navlinks:[
              {id:1,title:'首页',name:"Home"},
              {id:2,title:'免费课程',name:"Course"},
              {id:3,title:'轻课',name:"LightCourse"},
              {id:4,title:'学位课程',name:"Micro"}

          ]
      }
  },
  methods:{
    shop_cart(){
      this.$router.push({
        name:'shop_cart'
      })
    },
    enterHandler(){
      this.isShow = true;
    },
    leaveHandler(){
      this.isShow = false;
    },
  },
  created(){
    console.log('导航组件加载了')
  },
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
.el-header{
  border-bottom: #c9c9c9;
  box-shadow: 0 0.5px 0.5px 0 #c9c9c9;
}
.header{
  width: 1200px;
  height: 80px;
  line-height: 80px;
  margin: 0 auto;
}
.nav-left{
  float: left;
 margin-top: 10px;
}
.nav-center{
  float: left;
  margin-left: 100px;
}
.nav-center ul{
	overflow: hidden;
}
.nav-center  ul li{
	float: left;
	margin: 0 5px;
	/*width: 100px;*/
	padding: 0 20px;
	height: 80px;
	line-height: 80px;
    text-align: center;
    position: relative;
}
.nav-center ul li a{
	color: #4a4a4a;
	width: 100%;
	height: 60px;
	display: inline-block;

}
.nav-center ul li a:hover{
	color: #B3B3B3;
}
.nav-center ul li a.is-active{
	color: #4a4a4a;
    border-bottom: 4px solid #ffc210;
}

.nav-center ul li span{
    color: red;
    font-size: 12px;
    position:absolute;
    top: -12px;
    right: -3px;
}
.nav-right{
  float: right;
  position: relative;
  z-index: 100;
  
}
.nav-right span{
  cursor: pointer;
}
.nav-right .user{
	margin-left: 15px;
}
.nav-right img{
	width: 26px;
	height: 26px;
	border-radius: 50%;
	display: inline-block;
	vertical-align: middle;
	margin-left: 15px;
}
.nav-right  ul{
  position: absolute;
  width: 221px;
  z-index: 100;
  font-size: 12px;
  top: 80px;
  background: #fff;
  border-top: 2px solid #d0d0d0;
    box-shadow: 0 2px 4px 0 #e8e8e8;
}
.nav-right ul li{
    height: 40px;
    color: #4a4a4a;
    padding-left: 30px;
    padding-right: 20px;
    font-size: 12px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    cursor: pointer;
    transition: all .2s linear;
}
.nav-right ul li span.msg{
  margin-left: -80px;
  color: red;
}
.nav-right ul li span.count{
  margin-left: -100px;
  color: red;
}

</style>
