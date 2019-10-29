package com.hujingli.micro.service.impl;

import com.hujingli.micro.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 订单service业务实现
 */
@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 日志记录器
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private RestTemplate restTemplate;

    @Override
    public void save() {

        logger.debug("保存订单成功");

        // 调用库存服务 stock-service
        String url = "http://STOCK-SERVICE/stock/";
        HttpStatus statusCode = restTemplate.getForEntity(url, String.class).getStatusCode();


    }
}
