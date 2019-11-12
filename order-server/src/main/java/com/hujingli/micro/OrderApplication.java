package com.hujingli.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 服务提供方引导类
 */
@SpringBootApplication

/**
 * @EnableDiscoveryClient
 * 可以不用添加该注解也可启动并作为eureka-client注册到注册中心
 * 自动装配的时候默认给@link{EurekaDiscoveryClientConfiguration}
 */
@EnableJpaAuditing // 启用jpa审计
@EnableJpaRepositories(basePackages = {"com.hujingli.micro.dao"})
@EnableCircuitBreaker
@EntityScan(basePackages = "com.hujingli.micro.common.bean")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
}
