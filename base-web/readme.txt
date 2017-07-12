说明：
（1）这是一个基础的java web项目，完成了应用骨架的搭建，提供了底层框架的支持，但里面的内容是空白的，可以在此基础上进行项目开发或用来学习。
	运行环境为：maven3.2 + jdk1.8 + tomcat8 + mysql5 + redis。
	mysql可以换成其他的hibernate支持的数据库，中间件除了tomcat之外，jetty、weblogic、IBM was等都可以运行。
	集成的框架有：spring mvc + spring + hibernate + logback + apache cxf + junit，spring mvc、hibernate已经用注解配置方式替代 了传统的xml配置方式。
	logback在本项目中已经设置了一个aop切面，对所有的controller请求进行切面日志输出，实现的类是 cn.sky.framework.common.aop.AopLogs。
	cn.sky.framework.util 包中提供了常用的工具类，如 id 生成等。

（2）如果要对项目进行重命名，建议修改的配置如下：
	(a)重命名项目 baseWeb.
	(b)将 pom.xml、db.init.sql、jdbc.properties 这3个文件里面的 baseWeb 替换成新项目的名称.
	(e)如果要将 cn.sky 改成自己公司的域名的前缀，要修改的地方有：
		<1>在eclipse上将 src/main/java 下的包进行重命名. 
		<2>将 pom.xml、logback.xml、spring.xml、spring-mvc.xml、spring-cxf.xml 这5个文件中的 cn.sky 替换成自己公司域名前缀.

（3）本项目安装很简单，步骤如下：
	(a)将 db.init.sql 导入到 mysql 中执行，将创建一个数据库和一个数据表 test。
	(b)在 jdbc.properties 文件中输入正确的用户名和密码以及数据库名称.
	(c)在上面两步正确完成之后，用 maven 对本项目打包，生成一个 war 文件，将此文件放到 tomcat8 的 webapps 目录下，
		启动 tomcat，之后访问  http://localhost:{端口}/{项目名称}/test/index , 之后会出现一个测试页面，
		点击查询按钮，出现查询结果，至此，项目安装完成。

