const webpack = require('webpack')

module.exports = {
  configureWebpack: {
    plugins: [
      new webpack.ProvidePlugin({
        $: "jquery",
        jQuery: "jquery"
      })
    ]
  }
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
