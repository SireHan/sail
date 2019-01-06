<template>
	<div>
		Hello {{name}}
		<p>
			<img src="../static/images/girl.jpg" />
		</p>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				name: 'Vue.js'
			}
		}
	}
</script>

<style type="text/css" scoped>
	div{
		color: #f60;
		font-size: 24px;
	}
</style>