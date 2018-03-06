# e-world
学习日记：
1.一开始先选定好项目所需的工具，本项目选用  Spring,SpringMVC,Mybatis的框架组合模式开发；如果有不清楚的，最好是去当官方文档查阅；
2.之后使用Maven去创建我们的项目，这里要注意选用的是Maven-webapp项目，还是原生的，另外在创建好后，要注意，项目的web.xml比较老，把
servlet换成3.1版本的，这样可以使用el,还有要注意，在projectstructure中，修改项目module，新建java,test标记好颜色；
3.之后一个项目的框架就做好了，这个时候，我们要先准备材料，工欲善其事，必先利其器。我们就要开始依赖注入了！
4.依赖注入，分为4个大部分，日志，数据库，web相关，Spring框架相关
5.准备工作到此结束

Mybatis是做什么的？
我们需要一个映射过程，映射我们的实体对象
参数+SQL（SQL完全由自己来写，很灵活）=entity/list

SQL写在哪里？   1.写在一个XML文件中 （主流）   2.写在注解里
如何实现Dao接口？  1.Mapper自动实现Dao接口(主流)    2.API编程（connection,statement,....）
