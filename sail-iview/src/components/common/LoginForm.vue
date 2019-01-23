<template>
    <Form :model="loginForm" >
        <FormItem>
            <Input prefix="ios-contact" placeholder="请输入用户名" style="width: auto" />
        </FormItem>
    </Form>
</template>

<script>
    export default {
        name: "loginForm",
        data(){
            return{
                loginForm:{}
            }
        }
    }
</script>

<style scoped>

</style>