package com.hujingli.micro;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 库存服务启动引导类
 */
@SpringBootApplication
@EnableCircuitBreaker
/**
 * @EnableCircuitBreaker
 *
 * 可以使用@SpringCloudApplication来进行替换上面两个注解
 */
public class StockApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class);
    }
}
