<template>
    <div class="about">
        <h1>This is an about page</h1>
        <Cascader :data="cascaderData" :load-data="getChildrenCity"></Cascader>
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
                $.ajax.get('api/basic/city/loadCityList').then(data => {
                    this.cascaderData = data;
                })
            },
            getChildrenCity (item, callback) {
                item.loading = true;
                $.ajax.get('api/basic/city/loadCityList',{
                    params: {
                        parentId: item.value
                    }
                }).then(data => {
                    console.log(data);
                    item.children = data;
                    item.loading = false;
                    callback();
                })
            }
        }
    }
</script>
