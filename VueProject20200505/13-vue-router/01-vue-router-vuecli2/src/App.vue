<template>
  <div id="app">
    <!--默认是将router-link渲染成a标签-->
    <!--<router-link to="/home">首页</router-link>-->
    <!--<router-link to="/about">关于</router-link>-->

    <!--通过tag属性修改我们自己需要渲染的标签，这个渲染后，可以点击浏览器的前进后退  采用的是history.pushStat()-->
    <!--<router-link to="/home" tag="button">首页</router-link>-->
    <!--<router-link to="/about" tag="button">关于</router-link>-->

    <!--采用history.replace()方法就不能使用浏览器的额前进后退了-->
    <!--active-class自定义属性名-->
    <!--<router-link to="/home" tag="button" replace active-class="active">首页</router-link>-->
    <!--<router-link to="/about" tag="button" replace active-class="active">关于</router-link>-->


    <!--采用在路由配置active-->
    <!--<router-link to="/home" tag="button" replace>首页</router-link>-->
    <!--<router-link to="/about" tag="button" replace>关于</router-link>-->

    <!--采用代码方式，跳转路由-->
    <!--<button @click="homeClick">首页</button>-->
    <!--<button @click="aboutClick">关于</button>-->
    <!--<button @click="userClick">用户</button>-->
    <!--<button @click="profileClick">档案</button>-->


    <!--<br>-->
    <!--<hr>-->

    <router-link to="/home" tag="button">首页</router-link>
    <router-link to="/about" tag="button">关于</router-link>
    <router-link :to="'/user/'+userId" tag="button">我的</router-link>

    <!--<router-link to="/profile" tag="button">档案</router-link>-->
    <!--改写成对象的形式-->
    <!--<router-link :to="{path: '/profile'}" tag="button">档案</router-link>-->

    <!--传递参数-->
    <router-link :to="{path: '/profile', query: {name: 'Robin',age: 18, height: 1.88}}" tag="button">档案</router-link>


    <keep-alive>
      <router-view></router-view>
    </keep-alive>
  </div>
</template>

<script>
export default {
  name: 'App',
  data(){
    return{
      userId: 'robin'
    }
  },
  methods:{
    //$router是整个大的Router对象
    // homeClick() {
    //   this.$router.push('/home');
    //   console.log('homeClick');
    // },
    // aboutClick() {
    //   this.$router.push('/about');
    //   console.log('aboutClick');
    // },
    // userClick() {
    //   this.$router.push('/user/' + this.userId);
    // },
    // profileClick() {
    //   this.$router.push({
    //     path: '/profile',
    //     query: {
    //       name: 'Kobe',
    //       age: 19,
    //       height: 1.87
    //     }
    //   });
    // }
  }
}
</script>

<style>

  /*.router-link-active{*/
    /*color: red;*/
  /*}*/

.active{
  color: red;
}
</style>
