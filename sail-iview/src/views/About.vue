<template>
    <div class="about">
        <h1>This is an about page</h1>
        <Cascader :data="cascaderData"></Cascader>
    </div>
</template>
<script>
    import $ from '../lib/util';

    export default {
        data() {
            return {
                cascaderData: []
            }
        },
        mounted() {
            this.getFirstLevelCity();
        },
        methods: {
            getFirstLevelCity() {
                $.ajax.get('api/basic/city/loadCityList').then(res => {
                    console.log(res);
                })
            }
        }
    }
</script>
