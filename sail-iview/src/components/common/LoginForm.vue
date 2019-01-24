<template>
    <Form :model="loginForm" :rules="ruleValidate" ref="loginForm">
        <FormItem prop="loginName">
            <Input placeholder="请输入用户名"
                    clearable
                   v-model="loginForm.loginName">
                <span slot="prepend"><Icon type="ios-person-outline"/></span>
            </Input>
        </FormItem>
        <FormItem prop="password">
            <Input placeholder="请输入密码"
                    clearable
                   v-model="loginForm.password">
                <span slot="prepend"><Icon type="ios-lock-outline"/></span>
            </Input>
        </FormItem>
        <FormItem>
            <Button type="primary" @click="handleSubmit()" long>登录</Button>
        </FormItem>
    </Form>
</template>

<script>
    export default {
        name: "loginForm",
        data(){
            return{
                loginForm:{
                    loginName:'',
                    password:''
                },
                ruleValidate:{
                    loginName:[
                        { required: true, message: '用户名不能为空', trigger: 'blur' }
                    ],
                    password:[
                        { required: true, message: '密码不能为空', trigger: 'blur' }
                    ]
                }
            }
        },
        methods:{
            handleSubmit(){
                this.$refs['loginForm'].validate((valid) => {
                    if (valid) {
                        this.$emit('on-success-valid', {
                            loginName: this.loginForm.loginName,
                            password: this.loginForm.password
                        })
                    }
                })
            }
        }
    }
</script>

<style scoped>

</style>