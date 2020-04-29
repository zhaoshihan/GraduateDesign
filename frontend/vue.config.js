const webpack = require('webpack')

module.exports = {
  lintOnSave: false // 关闭eslint
};


// module.exports = {
  // configureWebpack: {
  //   plugins: [
  //     new webpack.ProvidePlugin({
  //       $: "jquery",
  //       jQuery: "jquery"
  //     })
  //   ]
  // }
  // devServer: {
  //   proxy: {
  //     '/api': {
  //       target: 'http://localhost:8081',
  //       changeOrigin: true,
  //       pathRewrite: {
  //         '^/api': ''
  //       }
  //     }
  //   }
  // }
// }
