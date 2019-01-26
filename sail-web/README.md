# api 接口说明
## 公共基础部分
### CityController

> * loadCityList  接口
>  ##### 1）接口描述
>      用户实现三级地区的选择 懒加载模式 
>      参数为空 默认显示所有第一层级的行政区划，否则显示父级的子行政区划
>  ##### 2）参数
>  | 参数名        | 类型   |  描述  |
>  | --------   | -----:  | :----:  |
>  | parentId     | Long |   父级id     |
>  ##### 3）返回值
>       List<Tree> 
>          Tree 当前层级的Tree内容
## sys 基础系统部分
### LoginController
 
> * loginValidator  接口
>  ##### 1）接口描述
>      session 验证用户是否登录
>  ##### 2）参数 （无）
>  ##### 3）返回值
>       BaseOpMsg<Object>
>          Object ：boolean : true/false
> * userInfo  接口
>  ##### 1）接口描述
>      获取账户所有信息
>  ##### 2）参数
>  | 参数名        | 类型   |  描述  |
>  | --------   | -----:  | :----:  |
>  | loginName     | String |   账户名     |
>  ##### 3）返回值
>       BaseOpMsg<UserInfo>
>           UserInfo 账户的详细信息

