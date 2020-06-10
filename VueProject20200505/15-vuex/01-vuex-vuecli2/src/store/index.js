import Vue from 'vue'
import Vuex from 'vuex'

// 1.安装vuex
Vue.use(Vuex)


// 2.使用vuex

const moduleA = {
  state: {
    name: 'zhangsan'
  },
  mutations: {
    updateName(state, payload) {
      state.name = payload;
    }
  },
  actions: {
    // 此处的context是，该模块下的context
    aUpdateName(context){
      console.log(context);
      setTimeout(()=>{
        context.commit('updateName','wangwu')
      },1000)
    }
  },
  getters: {
    fullName(state) {
      return state.name + '123456'
    },
    fullName2(state, getters) {
      return getters.fullName + '222'
    },
    fullName3(state, getters, rootState) {
      return getters.fullName2 + rootState.counter
    }
  },
}

const store = new Vuex.Store({
  state: {
    counter: 25,
    students: [
      {id: 100, name: 'Robin', age: 18},
      {id: 101, name: 'Coco', age: 22},
      {id: 102, name: 'Vue', age: 6},
      {id: 104, name: 'Kobe', age: 30}
    ],
    info: {
      name: 'King',
      age: 28,
      height: 1.88
    }
  },
  //同步方式使用这个
  mutations: {
    // 方法
    increment(state) {
      state.counter++
    },
    decrement(state) {
      state.counter--
    },
    // 第二个参数称为是载荷payload
    incrementCount(state, count) {
      state.counter += count
    },
    updateInfo(state) {
      state.info.name = 'coding'
      // 这样修改不是响应式的
      // state.info['address'] = '北京';
      // Vue.set()  Vue.delete() 这2个方法是响应式的  推荐使用
      // Vue.set(state.info,'address','北京')
      // Vue.delete(state.info,'age')

      //异步处理时  不能实现实时更新的，需要使用actions
      // 错误代码
      // setTimeout(()=>{
      //   state.info.name = 'coding..'
      // },1000)

    }
  },
  // 涉及到异步操作的是，通融使用actions方法
  actions: {
    // aUpdateInfo(context){
    //   setTimeout(()=>{
    //     // console.log('payload');
    //     context.commit('updateInfo')
    //   },1000)
    // }

    // 与mutations一样也是可以传递参数的
    // aUpdateInfo(context,payload){
    //   setTimeout(()=>{
    //     console.log(payload);
    //     context.commit('updateInfo')
    //   },1000)
    // }

    // aUpdateInfo(context,payload){
    //   setTimeout(()=>{
    //     console.log(payload.message);
    //     context.commit('updateInfo');
    //     payload.success();
    //   },1000)
    // }

    // 总结：有异步操作的时候，一定是在actions中的
    //       Actions本身执行后，会返回一个Promise的    return new Promise
    aUpdateInfo(context, payload) {
      // 这样写会报错undefined，出现resolve('1111')中的参数没能传递出去
      // 核心原因是，我们没有执行return Promise
      // new Promise((resolve,reject)=>{
      return new Promise((resolve, reject) => {//这样就不会报错undefined
        setTimeout(() => {
          context.commit('updateInfo');
          console.log(payload);

          resolve('1111')
        }, 1000)
      })
    }
  },
  getters: {
    powerCounter(state) {
      return state.counter * state.counter
    },
    more20Stu(state) {
      return state.students.filter(s => s.age > 20)
    },
    more20StuLength(state, getters) {
      return getters.more20Stu.length
    }
  },
  modules: {
    // 可以直接划分为多个模块  一般最多2个模块
    // 此处我们采用抽离的方式，看起来更美观
    a: moduleA,
    b: {}


  }
})


// 3.导出vuex即store
export default store

/*
补充知识，对象的解构
const obj = {
  name: 'Robin',
  age: 18,
  height: 1.88
}

大括号里面的内容的顺序是可以变化的
const {name,age,height} = obj;
*/
