# hrms-api

HRMS人事管理系统后端 

前端项目：[hrms-app](https://gitee.com/byx2000/hrms-app)

预览地址：[http://182.92.74.74/](http://182.92.74.74/)

## 包结构

* `byx.project.aspect`: 切面类
* `byx.project.common`: 公共类
* `byx.project.config`: 配置类
* `byx.project.exception`: 异常类
* `byx.project.pojo.vo`: 视图对象，用于封装在用户界面上展示的数据
* `byx.project.pojo.dto`: 数据传输对象，用于在前端与后端、以及后端各层之间传递数据  
* `byx.project.mapper`: 数据访问层接口
* `byx.project.service`: 业务逻辑接口
* `byx.project.service.impl`: 业务逻辑实现类
* `byx.project.controller`: 控制器

## 重要类及其说明

* `byx.project.aspect.ControllerExceptionHandler`: 统一异常处理切面
* `byx.project.common.Result`: 封装JSON返回结果
* `byx.project.common.Status`: 返回状态码枚举
* `byx.project.config.WebMvcConfig`: Spring MVC的配置类   
* `byx.project.exception.BizException`: 业务逻辑异常类
* `byx.project.hrms.pojo.dto.PagingQueryDTO`: 带分页参数的DTO基类

## 注意事项

* 每个网络请求传递的参数都要用一个DTO封装起来，即使只有一个字段
* 每个请求参数对应的DTO字段上要加校验规则
* 如果有分页的需求，可以让定义的DTO继承自`PagingQueryDTO`，无需自己再定义分页参数
* 每个pojo都要加`@Getter`、`@Setter`和`@ToString`
* 参数校验异常会自动封装成`Result`并返回给客户端
* 所有Controller返回的结果要用`Result`封装起来，并且全部都是`PostMapping`
* 如果service执行过程中需要报错，需要在`Status`中定义一个新的状态码，然后在代码中throw一个`BizException`并把状态码传入，统一异常处理会把错误信息封装成`Result`返回给客户端
