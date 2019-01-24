<template>
    <div class="loginDiv">
        <Row type="flex" justify="center" align="middle" style="height: 100%">
            <Col :xs="12" :md="8" :sm="8" :lg="4">
                <Card style="height:100%">
                    <div style="text-align:center" slot="title">
                        <img src="../../assets/images/logo.png" class="logoImg"/>
                        <h3>基础管理系统</h3>
                    </div>
                    <LoginForm @on-success-valid="loginAction"></LoginForm>
                </Card>
            </Col>
        </Row>
    </div>
</template>

<script>
    import LoginForm from '_c/common/LoginForm'
    import { mapActions } from 'vuex'
    export default {
        name: "login",
        components: {LoginForm},
        methods:{
            ...mapActions([
                'handleLogin',
                'updateUserInfo'
            ]),
            loginAction({loginName,password}){
                this.handleLogin({loginName,password}).then(() => {
                    this.updateUserInfo().then(data => {
                        this.$router.push({
                            name: data.homeName || this.$config.homeName
                        })
                    })
                })
            }
        }
    }
</script>

<style scoped lang="scss" type="text/css">
    .loginDiv{
        width: 100%;
        height: 100%;
        background-image: url('../../assets/images/login-bg.jpg');
        background-size: cover;
        background-position: center;
    }
    .logoImg{
        width: 80px;
    }
</style>