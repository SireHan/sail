var merge = require('webpack-merge');
var webpackBaseConfig = require('./webpack.config.js');
var MiniCssExtractPlugin  = require('mini-css-extract-plugin');
var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = merge(webpackBaseConfig,{
	output: {
		publicPath: './',
		filename: '[name].[hash].js',
		chunkFilename: '[name].[hash].js'
	},
	mode: "production", // 生产模式
	plugins:[
		new HtmlWebpackPlugin({
	      template: './src/app.html',
	      filename: 'index.html'
	    }),
		new MiniCssExtractPlugin({
			filename: "[name].[hash].css",
			chunkFilename: "[id].[hash].css"
		})
	]
})