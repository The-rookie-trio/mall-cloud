package org.trt.micro.malladmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//开始Spring boot监控
@EnableAdminServer
public class MallAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAdminApplication.class, args);
    }

}
