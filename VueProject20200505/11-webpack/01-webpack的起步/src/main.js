//采用commonJS
const {add,mul} = require('./mathUtils.js')

console.log(add(2, 3));
console.log(mul(30, 20));

// 采用ES6
import {name, age, height} from "./info";

console.log(name);
console.log(age);
console.log(height);


//
// webpack如果是3.xxx，打包命令是：
//     webpack ./src/main.img  ./dist/bundle.img
//
//
// 因为我们使用的webpack版本是4.xx的，所有打包命令是：
//     npx webpack ./src/main.img -o ./dist/bundle.img --mode development
//


// 如果实在vscode中执行，需要
// 管理员运行vscode,然后在终端输入set-ExecutionPolicy RemoteSigned
// 然后在执行：npx webpack ./src/main.img -o ./dist/bundle.img --mode development



