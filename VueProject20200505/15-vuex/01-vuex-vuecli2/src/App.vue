<template>
  <div id="app">
    <!--<img src="./assets/logo.png">-->
    <!--<router-view/>-->
    <h2>-------------App内容:modules中的美容--------------</h2>
    <h2>{{$store.state.a.name}}</h2>
    <button @click="updateName">修改名字</button>
    <h3>{{$store.getters.fullName}}</h3>
    <h3>{{$store.getters.fullName2}}</h3>
    <h3>{{$store.getters.fullName3}}</h3>
    <button @click="asycUpdateName">异步更新名字</button>
    <br>

    <h2>-------------App内容:info对象的内容是否是响应式--------------</h2>
    <h2>{{$store.state.info}}</h2>
    <button @click="updateInfo">更新Info信息</button>
    <br>

    <h2>-------------App内容--------------</h2>
    <h2>{{message}}</h2>
    <h2>{{$store.state.counter}}</h2>
    <!--Vue官方不推荐使用一下方法，不能监控到状态管理处的值-->
    <!--<button @click="$store.state.counter++">+</button>-->
    <!--<button @click="$store.state.counter&#45;&#45;">-</button>-->


    <button @click="addNum">+</button>
    <button @click="subNum">-</button>
    <button @click="addCount(5)">+5</button>
    <button @click="addCount(10)">+10</button>

    <hr>
    <h2>-------------App内容:Getters相关信息--------------</h2>
    <h2>{{$store.getters.powerCounter}}</h2>
    <!--<h2>{{more20Stu}}</h2>-->
    <h2>{{$store.getters.more20Stu}}</h2>
    <h2>{{$store.getters.more20Stu.length}}</h2>
    <h2>{{$store.getters.more20StuLength}}</h2>


    <hr>
    <h2>-------------HelloVuex内容--------------</h2>
    <hello-vuex></hello-vuex>

  </div>
</template>

<script>

  import HelloVuex from './components/HelloVuex'

export default {
  name: 'App',
  components: {
    HelloVuex
  },
  data(){
    return{
      message: 'Vuex...'
    }
  },
  computed: {
    // more20Stu() {
    //   return this.$store.state.students.filter(s=>{
    //     return s.age > 20
    //   })
    // }
  },
  methods:{
    // 为何使用commit，而没有使用state，这个查看一下vuex状态管理图例文档即可
    // this.$store.state仅可用来访问状态，不可以修改状态
    // this.$store.commit()用来修改状态的
    addNum() {
      this.$store.commit('increment')
    },
    subNum() {
      this.$store.commit('decrement')
    },
    addCount(count){
      // 1.普通提交封装 count及时一个简单的数字
      this.$store.commit('incrementCount',count)

      // 2.特殊的提交封装  这个方式，count是一个对象
      // this.$store.commit({
      //   type: 'incrementCount',
      //   count: count
      // })
    },
    updateInfo() {
      // 同步
      // this.$store.commit('updateInfo')
      // 异步 无参数传递
      // this.$store.dispatch('aUpdateInfo')

      // // 异步 有参数传递
      // this.$store.dispatch('aUpdateInfo','我是payload.....')

      // 可以操作空间很大
      // this.$store.dispatch('aUpdateInfo',{
      //   message: '我是携带的信息...',
      //   success: ()=>{
      //     console.log('里面内容已经完成');
      //   }
      // })

      // 采用Promise形式
      this.$store
        .dispatch('aUpdateInfo', '我是携带的信息')
        .then(res => {
          console.log('里面已经完成提交');
          console.log(res);
        })

    },
    updateName(){
      this.$store.commit('updateName','lisi')
    },
    asycUpdateName() {
      this.$store.dispatch('aUpdateName')
    }
  }
}
</script>

<style>

</style>
