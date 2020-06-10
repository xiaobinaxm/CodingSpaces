<template>
  <div>
    <h2>我是首页</h2>
    <p>我是首页内容，哈哈哈哈</p>

    <router-link to="/home/news">新闻</router-link>
    <router-link to="/home/message">消息</router-link>

    <router-view></router-view>
  </div>
</template>

<script>
    export default {
      // name一般是不适用的，在排除某些组件是，需要使用到这个名字
        name: "Home",
      data() {
          return{
            path: '/home/news'
          }
      },
      //这2个函数只有组件在使用了keep-alive时，才有效
      activated(){
        // console.log('home active...');
        this.$router.push(this.path);
      },
      // deactivated(){
      //   console.log('home deactived...');
      // },
      beforeRouteLeave(to, from, next) {
        // console.log('this.$route.path');
        //使用path属性记录离开时的路径
        this.path = this.$route.path;
        next();
      }
    }
</script>

<style scoped>

</style>
