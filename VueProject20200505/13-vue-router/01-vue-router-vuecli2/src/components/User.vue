<template>
  <div>
    <h2>我是用户界面</h2>
    <span>我是用户相关内容，嘿嘿....</span>
    <h2>{{userId}}</h2>
    <h2>{{$route.params.userId}}</h2>
  </div>
</template>

<script>
    export default {
        name: "User",
        computed: {
          userId(){
            // $route是当前处于活跃的路由配置
            return this.$route.params.userId
          }
        }
    }
</script>

<style scoped>

</style>
