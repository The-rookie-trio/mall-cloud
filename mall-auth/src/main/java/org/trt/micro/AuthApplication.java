package org.trt.micro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 15 日
 * @Description 认证授权启动类
 */
@SpringBootApplication
@MapperScan("org.trt.micro.dao")
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }

}
