var merge = require('webpack-merge');
var webpackBaseConfig = require('./webpack.config.js');
var MiniCssExtractPlugin  = require('mini-css-extract-plugin');
var HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = merge(webpackBaseConfig,{
	output: {
		publicPath: '/dist/',
		filename: '[name].js',
		chunkFilename: '[name].js'
	},
	mode: "development", // 生产模式
	plugins:[
		new HtmlWebpackPlugin({
	      template: './index.html',
	      filename: 'index.html'
	    }),
		new MiniCssExtractPlugin({
			filename: "[name].css",
			chunkFilename: "[id].css"
		})
	]
})