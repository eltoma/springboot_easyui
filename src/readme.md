# 项目介绍
Lab108教研室管理系统


# 坑们在这里~~
## @SpringBootApplication标注的类(即系统的Boot类)的所处包的位置限制
- 必须位于Controller类的父级包内，即boot类所在的包必须是所有controller类所在的包的父包
- 不能位于default包中
- 原因待查

## @Configuration注解**
- 指示某个类成为一个配置类，会在应用启动时执行其中的方法，构造Bean,代替配置XML功能
