# mybatis-log-demo

 使用插件的方式集成打印mybatis sql 的日志，方便查看 日志的格式 [mybatis sql print plugins](https://github.com/WangJi92/mybatis-sql-log)
 
 ```xml
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.0</version>
        </dependency>
         <dependency>
            <groupId>com.github.WangJi92</groupId>
            <artifactId>mybatis-sql-log</artifactId>
            <version>1.0.3</version>
        </dependency>
```
mybatis.print=true 使用spring boot 工程集成

org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration 内部自动集成了插件
```xml
mybatis.print=true
server.port = 7012
#数据库连接
spring.datasource.url = jdbc:mysql://127.0.0.1:3306/test
spring.datasource.username = root
spring.datasource.password = mysql-root
spring.datasource.driver-class-name= com.mysql.jdbc.Driver
spring.datasource.hikari.connection-test-query = SELECT 1
```
效果

```xml
2019-08-31 12:41:35.975  INFO 3258 --- [nio-7012-exec-3] s.b.a.MybatisSqlCompletePrintInterceptor : SQL:select name, age, type from user WHERE ( name = /*__frch_criterion_1.value*/'汪吉' )    执行耗时=6
```

或者通过mybatis-config原生配置处理
```text
<!-- mybatis-config.xml -->
<plugins>
  <plugin interceptor="com.mybatis.spring.boot.autoconfigure.MybatisSqlCompletePrintInterceptor">
  </plugin>
</plugins
```

## 集成 mapper xml 重载

[mybaits mapper xml 热更新](https://github.com/WangJi92/mybatis-mapper-reload-spring-boot-start)
mybatis.mapper.reload.enable=true
mybatis.mapper.reload.mapper-location=classpath*:/**/*apper*.xml

```xml
 <dependency>
    <groupId>com.github.WangJi92</groupId>
    <artifactId>mybatis-mapper-reload-sping-boot-start</artifactId>
    <version>0.0.3</version>
</dependency>
```
