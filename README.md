# MyBatis code generator

## 中文

一个mybatis代码自动生成器，根据库表中的元数据，自动生成DO，DTO，Service， ServiceImpl，DAO，及mybatis的sqlmap文件。

### 工程说明

mybatis-generator-api：定义了公共类及接口抽象

mybatis-generator-mysql：MySQL数据库的实现，如果要实现对其它数据库的支持，只需要参考此工程实现简单的几个类，及写好MyBatis的mapper对应的xml文件即可。

mybatis-generator-sample：示例运行工程，按需要修改resources下properties文件再运行即可。

具体的参数说明请参考文件内的注释。

### TODO：

* 代码重构
* 基于抽象，实现多数据库扩展
* 编写运行脚本

## English

MyBatis code generator is a code auto generator framework, 
it can auto generate these classes: DO, DTO, Service, ServiceImpl, DAO, AND sqlmap file for MyBatis.

### about project

mybatis-generator-api: defined common class and abstract interface

mybatis-generator-mysql: MySQL implement, if you want to implement another db support, just only write a few classes like this project, and modify MyBatis's mapper xml files.

mybatis-generator-sample: example project, modify properties files in resources directory for your need.

about confit parameters, please reference the comments.

### TODO:

* code refactor
* multi relationship db support
* write run script
