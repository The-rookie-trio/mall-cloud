package org.trt.micro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 21 日
 * @Description 商城后台管理端应用
 */
@SpringBootApplication
@MapperScan("org.trt.micro.distributelock.mysql.dao")
public class MallAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAdminApplication.class);
    }

}
