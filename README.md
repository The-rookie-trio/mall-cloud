# hujingli-cloud
spring-cloud搭建微服务项目


1、首先搭建的是注册中心eureka-server服务

2、然后加入服务提供方

  - order-server
  - stock-server

其中order-server也作为服务消费者

3、服务提供方加入服务容错保护

```
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```
