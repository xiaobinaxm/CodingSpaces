// 自己封装的，不在使用export default，可能会有多个函数对象
// 建议使用export function function名字
// export default instance1(){}
import axios from 'axios'

// export function request(config, success, failure) {
//   // 1.创建axios实例对象
//   const instance = axios.create({
//     baseURL: 'http://123.207.32.32:8000',
//     timeout: 5000
//   })
//
//   // 2.发送真正的网络请求
//   instance(config)
//     .then(res => {
//       success(res);
//     })
//     .catch(err => {
//       failure(err);
//     })

// export function request(config) {
//   // 1.创建axios实例对象
//   const instance = axios.create({
//     baseURL: 'http://123.207.32.32:8000',
//     timeout: 5000
//   })
//
//   // 2.发送真正的网络请求
//   instance(config.baseConfig)
//     .then(res => {
//       config.success(res);
//     })
//     .catch(err => {
//       config.failure(err);
//     })
// }

// 使用Promise
// export function request(config) {
//   return new Promise((resolve,reject)=>{
//     // 1.创建axios实例对象
//     const instance = axios.create({
//       baseURL: 'http://123.207.32.32:8000',
//       timeout: 5000
//     })
//
//     // 2.发送真正的网络请求
//     instance(config)
//       .then(res => {
//        resolve(res)
//       })
//       .catch(err => {
//         reject(err)
//       })
//   })
// }

// 终极版本
export function request(config) {
  // 1.创建axios实例对象
  const instance = axios.create({
    baseURL: 'http://123.207.32.32:8000',
    timeout: 5000
  })

  // 2.axios的拦截器
  // axios.interceptors  全局拦截器
  // 这里采用局部拦截器即可，因为我们自己搞了一个instance
  instance.interceptors.request.use(config=>{
    console.log(config);
    // 拦截过后，必须返回给实例
    return config;
  },error => {
    console.log(err);
  });
  instance.interceptors.response.use(res=>{
    console.log(res);
    // res.data
    // 同样的，响应拦截过后，也是必须放行的，一般来说，我们只需要放行data就行
    return res.data;
  },err => {
    console.log(err);
  });


  // 3.发送真正的网络请求
  return instance(config)
}

// 理解回调函数
// 定义函数
function test(aaa, bbb) {
  // 这里面的aaa、bbb开始反过来调用原本执行【调用函数test】
  aaa('hell world');//将hello world传递给res，然后打印到控制台
  bbb('err message');//将err message传递给err，然后控制台打印
}

// 调用函数test
test(function (res) {
  console.log(res);
},function (err) {
  console.log(err);
})


