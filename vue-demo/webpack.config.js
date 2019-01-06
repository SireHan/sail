var path = require('path');
var MiniCssExtractPlugin  = require('mini-css-extract-plugin');
var VueLoaderPlugin = require('vue-loader/lib/plugin');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var CopyWebpackPlugin = require('copy-webpack-plugin');

var config = {
	entry: {
		main: './src/app.js'
	},
	output: {
		path: path.join(__dirname,'./dist')
	},
	resolve: {
	    extensions: ['.js', '.vue', '.json'],
	    alias: {
	      'vue$': 'vue/dist/vue.esm.js',
	      '@': path.resolve(__dirname, 'src'),
	    }
	},
	module: {
		rules: [
			{
				test: /\.css$/,
				use: [
		          MiniCssExtractPlugin.loader,
		          "css-loader"
		        ]
			},
			{
				test: /\.vue$/,
				loader: 'vue-loader'
			},
			{
				test: /\.js$/,
				loader: 'babel-loader',
				include: [path.resolve(__dirname, 'src')],
        		exclude: [path.resolve(__dirname, 'node_modules')]
			},
			{
				test: /\.(gif|jpg|png|woff|svg|eot|ttf)\??.*$/,
				loader: 'url-loader?limit=1024'
			}
		]
	},
	plugins:[
		new VueLoaderPlugin(),
		new CopyWebpackPlugin([{
        	from: path.resolve(__dirname, 'static'),
        	to: path.resolve(__dirname, 'dist/static')
      	}])
	]
};

module.exports = config;