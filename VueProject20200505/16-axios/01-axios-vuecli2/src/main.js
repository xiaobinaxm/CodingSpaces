import Vue from 'vue'
import App from './App'
import axios from 'axios'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App)
})

/*
// 1.基本使用
// 为什么不是用Vue.use()，这个是使用插件的，vuex是插件，可以用，而axios是框架
axios({
  // 默认是get请求，如果需要使用其他方式，可以使用method进行配置
  url: 'http://123.207.32.32:8000/home/multidata',
  method: 'get'
}).then(res=>{
  console.log(res);
})


axios({
  // url: 'http://123.207.32.32:8000/home/data?type=sell&page=3'
  url: 'http://123.207.32.32:8000/home/data',
  // 专门针对get请求的参数拼接
  params: {
    type: 'pop',
    page: 2
  }
}).then(res=>{
  console.log(res);
})

// 也可以直接使用一下方式
// axios.get()
// axios.post()
*/



// 2.axios发送并发请求
// 使用格式 axios.all([axios(),axios()]).then()
// axios.all([
//     axios({
//       url: 'http://123.207.32.32:8000/home/multidata'
//     }),
//     axios({
//       url: 'http://123.207.32.32:8000/home/data',
//       params: {
//         type: 'sell',
//         page: 5
//       }
//     })
//   ]
// ).then(results => {
//   console.log(results);
//   console.log(results[0]);
//   console.log(results[1]);
// })

// 对于返回结果进行延展  展开结果显示
// axios.all([
//     axios({
//       url: 'http://123.207.32.32:8000/home/multidata'
//     }),
//     axios({
//       url: 'http://123.207.32.32:8000/home/data',
//       params: {
//         type: 'sell',
//         page: 5
//       }
//     })
//   ]
// ).then(axios.spread((res1,res2)=>{
//   console.log(res1);
//   console.log(res2);
// }))



// 对代码抽取  全局配置
// 使用全局的axios和对应的配置进行网络请求
/*
axios.defaults.baseURL = 'http://123.207.32.32:8000'
axios.defaults.timeout = 5000

axios.all([
    axios({
      url: '/home/multidata'
    }),
    axios({
      url: '/home/data',
      params: {
        type: 'sell',
        page: 5
      }
    })
  ]
).then(axios.spread((res1,res2)=>{
  console.log(res1);
  console.log(res2);
}))
*/

// 4.创建对象的axios实例
/*
const instance1 = axios.create({
  baseURL: 'http://123.207.32.32:8000',
  timeout: 5000
})

instance1({
  url: '/home/multidata',
}).then(res=>{
  console.log(res);
})

instance1({
  url: '/home/data',
  params: {
    type: 'pop',
    page: 4
  }
}).then(res=>{
  console.log(res);
})

// 如果需要多个实例的视乎，可以使用多个实例进行操作
// const instance2 = axios.create({})
// instance2({})
*/

// 5.封装request模块
// import request from './network/request'  //注意这里必须用大括号括起来
import {request} from './network/request'

// request({
//   url: '/home/multidata'
// }).then(res => {
//   console.log(res);
// }).catch(err => {
//   console.log(err);
// })

// request({
//   baseConfig:{
//
//   },
//   success: function (res) {
//
//   },
//   failure: function (err) {
//
//   }
// })


request({
  url: '/home/multidata'
}).then(res=>{
  console.log(res);
}).catch(err=>{
  console.log(err);
})






