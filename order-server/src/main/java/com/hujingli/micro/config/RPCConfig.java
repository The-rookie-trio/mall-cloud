package com.hujingli.micro.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * RestTemplate 启用负载均衡
 */
@Configuration
public class RPCConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
