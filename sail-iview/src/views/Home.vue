<template>
    <Layout class="layout">
        <Sider ref="sideMenu" hide-trigger collapsible breakpoint="md" :style="{background: '#515A6E'}"
               :collapsed-width="64" v-model="isCollapsed" class="left-sider">
            <div class="layout-logo">
                <span v-show="!isCollapsed" key="max-logo">管理系统</span>
                <img v-show="isCollapsed" :src="minLogo" key="min-logo"/>
            </div>
            <Menu v-show="!isCollapsed" theme="dark" active-name="1-2" width="auto" :open-names="['1']"
                  :class="menuitemClasses">
                <Submenu name="1">
                    <template slot="title">
                        <Icon type="ios-navigate"></Icon>
                        <span>Item 1</span>
                    </template>
                    <MenuItem name="1-1"><span>Option 1</span></MenuItem>
                    <MenuItem name="1-2"><span>Option 2</span></MenuItem>
                    <MenuItem name="1-3"><span>Option 3</span></MenuItem>
                </Submenu>
                <Submenu name="2">
                    <template slot="title">
                        <Icon type="ios-keypad"></Icon>
                        <span>Item 2</span>
                    </template>
                    <MenuItem name="2-1"><span>Option 1</span></MenuItem>
                    <MenuItem name="2-2"><span>Option 2</span></MenuItem>
                </Submenu>
                <Submenu name="3">
                    <template slot="title">
                        <Icon type="ios-analytics"></Icon>
                        <span>Item 3</span>
                    </template>
                    <MenuItem name="3-1"><span>Option 1</span></MenuItem>
                    <MenuItem name="3-2"><span>Option 2</span></MenuItem>
                </Submenu>
            </Menu>
            <div class="left-collapsed" v-show="isCollapsed">
                <a class="drop-menu-a" type="text"
                   :style="{textAlign: 'left'}">
                    <Icon type="ios-navigate" size="24" color="white"></Icon>
                </a>
                <a class="drop-menu-a" type="text"
                   :style="{textAlign: 'left'}">
                    <Icon type="ios-keypad" size="24" color="white"></Icon>
                </a>
            </div>
        </Sider>
        <Layout>
            <Header class="layout-header-bar" style="padding:0px 0px;background: #fff;height: 64px">
                <Menu mode="horizontal" theme="primary" active-name="1">
                    <div class="menu-collapsed">
                        <Icon @click.native="collapsedSider"
                              :class="rotateIcon" :style="{margin: '0 20px'}"
                              type="md-menu" size="24"></Icon>
                    </div>
                    <div class="layout-nav">
                        <MenuItem name="1">
                            <Icon type="ios-navigate"></Icon>
                            Item 1
                        </MenuItem>
                        <MenuItem name="2">
                            <Icon type="ios-keypad"></Icon>
                            Item 2
                        </MenuItem>
                        <MenuItem name="3">
                            <Icon type="ios-analytics"></Icon>
                            Item 3
                        </MenuItem>
                        <MenuItem name="4">
                            <Icon type="ios-paper"></Icon>
                            Item 4
                        </MenuItem>
                    </div>
                </Menu>
            </Header>
            <Layout :style="{padding: '0 24px 24px'}">

                <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
                    Content
                </Content>
                <Footer class="layout-footer-center">2011-2016 &copy; TalkingData</Footer>
            </Layout>
        </Layout>
    </Layout>
</template>

<script>
    // @ is an alias to /src
    import HelloWorld from '@/components/HelloWorld.vue'
    import minLogo from '@/assets/images/logo-min.png'
    import maxLogo from '@/assets/images/logo.png'

    export default {
        name: 'home',
        components: {
            HelloWorld
        },
        data() {
            return {
                isCollapsed: false,
                minLogo,
                maxLogo,
            }
        },
        computed: {
            rotateIcon() {
                return [
                    'menu-icon',
                    this.isCollapsed ? 'rotate-icon' : ''
                ];
            },
            menuitemClasses: function () {
                return [
                    'menu-item',
                    'menu-heigh',
                    this.isCollapsed ? 'collapsed-menu' : ''
                ]
            }
        },
        methods: {
            collapsedSider() {
                this.$refs.sideMenu.toggleCollapse();
            }
        }
    }
</script>

<style>
    .layout {
        height: 100%;
    }

    .left-sider {
        overflow: hidden
    }

    .layout .left-sider .ivu-layout-sider-children {
        overflow-y: scroll;
        margin-right: -18px;
    }

    .layout-logo {
        height: 62px;
        background: #515A6E;
        border-radius: 3px;
    }

    .layout-logo span {
        display: block;
        text-align: center;
        line-height: 64px;
        font-size: 20px;
        color: white;
    }

    .layout-header-bar {
        box-shadow: 0 1px 1px rgba(0, 0, 0, .1);
    }

    .left-collapsed {
        padding-top: 10px;
    }

    .left-collapsed .drop-menu-a {
        display: inline-block;
        padding: 6px 15px;
        width: 100%;
        text-align: center;
        color: #495060;
    }

    .menu-collapsed {
        width: 100px;
        height: 30px;
        border-radius: 3px;
        float: left;
    }

    .menu-icon {
        transition: all .3s;
    }

    .rotate-icon {
        transform: rotate(-90deg);
    }

    .menu-heigh {
        /* height: 100%;*/
    }

    .menu-item span {
        display: inline-block;
        overflow: hidden;
        width: 69px;
        text-overflow: ellipsis;
        white-space: nowrap;
        vertical-align: bottom;
        transition: width .2s ease .2s;
    }

    .menu-item i {
        transform: translateX(0px);
        transition: font-size .2s ease, transform .2s ease;
        vertical-align: middle;
        font-size: 16px;
    }

    .collapsed-menu span {
        width: 0px;
        transition: width .2s ease;
    }

    .collapsed-menu i {
        transform: translateX(5px);
        transition: font-size .2s ease .2s, transform .2s ease .2s;
        vertical-align: middle;
        font-size: 22px;
    }

    .layout-nav {
        width: 420px;
        margin: 0 auto;
        margin-right: 20px;
    }

    .layout-footer-center {
        text-align: center;
    }
</style>
