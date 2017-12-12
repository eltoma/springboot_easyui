# 项目介绍
Lab108教研室管理系统




# 坑&心得
## @SpringBootApplication标注的类(即系统的Boot类)的所处包的位置限制
- 必须位于Controller类的父级包内，即boot类所在的包必须是所有controller类所在的包的父包
- 不能位于default包中
- 原因待查

## @Configuration注解
- 指示某个类成为一个配置类，会在应用启动时执行其中的方法，构造Bean,代替配置XML功能

## @Service注解
- 抽象意义：将一个具体类标记为一种Service
- 实质意义：将类注册为Spring容器的一个bean

## starter项目
- 各种starter项目是springboot的关键
- 如果你想把你的某个模块融入spring-boot那么写一个对应的starter项目就是关键一步（像一个适配器）
- starter项目将各类模块的配置集中到application-(dev/prod).*中
- spring-boot带来各种自动配置功能，底层的本质是：```扫描classpath 和 约定匹配```

## maven <dependencyManagement>和<parent>标签
- <dependencyManagement>用于``声明依赖`` 并不 ``引入依赖``
- <parent>声明要继承的POM, 引入父POM中<dependencyManagement>所声明的依赖（版本号）
- 两者配合使用可以通过根父项目控制子项目依赖的jar包的```版本号```

## 注解的定义和使用
### 注解定义
- 定义注解：
    - @Target 注解使用的位置（方法，类，包...）
    - @Retention 保留的级别（源码->编译->运行时）
    - 元素值（成员变量）
        - 没有元素值的注解是 标记注解
- 注解解释器（关键）:读取和利用注解信息
### 使用注解
- 在合适的地方放上注解
- 设置注解的元素值

## mybaties注解映射说明
- 地址：http://www.mybatis.org/mybatis-3/zh/java-api.html
