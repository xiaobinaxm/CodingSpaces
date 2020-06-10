<template>
  <div>
    <h2>我是Profile组件</h2>
    <p>我是Profile内容.....</p>

    <p>{{$route.query.name}}</p>
    <p>{{$route.query.age}}</p>
    <p>{{$route.query.height}}</p>
  </div>
</template>

<script>
    export default {
        name: "Profile"
    }
</script>

<style scoped>

</style>
