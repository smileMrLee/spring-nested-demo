# Read Me First
本项目用于验证：spring 事务传播机制，启动前请先执行数据库脚本。执行完毕后，请修改数据库连接信息。

* 数据库脚本参看本项目根路径：lee_test.sql 文件

本项目采用springboot + mybatis + mysql技术栈。
调试入口请参看：CrudTestController

# 验证设计说明
demo中，我们设计两个接口test/required、test/nested 分别用来测试required和nested的传播机制。

通过入参中的remark是否包含：childError 和 mainError 文本来控制主方法和子方法是否抛出异常，从而进行回滚。当我们请求以下连接后，可以去数据库里检查数据入库和回滚情况。
同时观察日志输出情况，加以验证。

- required case1

required主方法和required子方法正常提交：http://localhost:8080/test/required?name=changle&remark=required_required

- required case2

required主方法因required子方法异常回滚：http://localhost:8080/test/required?name=lisi&remark=required_required_childError

- required Case3

required主方法异常连带required子方法异常回滚：http://localhost:8080/test/required?name=lisi&remark=required_required_childError



- nested Case1

required主方法正常提交-nested子方法异常回滚：http://localhost:8080/test/nested?name=lisi&remark=required_nested_childError

- nested Case2

required主方法异常回滚-连带nested子方法回滚：http://localhost:8080/test/nested?name=lisi&remark=required_nested_mainError


- 其他

其他事务传播机制，可基于上述的代码快速复制修改为对应的事务传播机制，即可快速验证。

