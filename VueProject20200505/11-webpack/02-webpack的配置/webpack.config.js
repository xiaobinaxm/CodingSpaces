const path = require('path');


// CommonJS
module.exports = {
    entry: './src/main.js',
    output: {
        // path: './dist',//官方建议使用绝对
        path: path.resolve(__dirname,'dist'),//注意这里是2个_,不是一个，一个报错,坑爹......
        filename: 'bundle.js'
    }
};
