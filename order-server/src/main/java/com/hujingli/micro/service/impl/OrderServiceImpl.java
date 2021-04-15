package com.hujingli.micro.service.impl;

import com.hujingli.micro.command.StockServiceCommand;
import com.hujingli.micro.common.bean.Order;
import com.hujingli.micro.common.exception.BusinessException;
import com.hujingli.micro.common.rest.response.BaseResponse;
import com.hujingli.micro.dao.OrderRepository;
import com.hujingli.micro.request.SaveOrderRequest;
import com.hujingli.micro.service.OrderService;
import com.hujingli.micro.service.StockServiceFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private StockServiceFeign stockServiceFeign;

    @HystrixCommand(fallbackMethod = "saveFallback")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SaveOrderRequest orderRequest) {

        logger.debug("订单保存，订单参数为:{}", orderRequest);

        Order order = new Order();
        BeanUtils.copyProperties(orderRequest, order);
        orderRepository.save(order);

        // TODO: 2019/11/12 这里应该会涉及到分布式事务的问题
        // 调用库存服务 stock-service
        String url = "http://STOCK-SERVICE/stock/";
        logger.debug("访问库存服务，url:{}", url);
        HttpStatus statusCode = restTemplate.getForEntity(url, String.class).getStatusCode();
        if (statusCode != HttpStatus.OK) {
            logger.debug("库存扣减失败");
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "下单失败");
        }

    }

    /**
     * 使用feign来进行远程调用
     */

    @Override
    public BaseResponse testFeign() {

        logger.info("进入order服务的service，进行订单操作");

        // 调用库存

        logger.info("调用库存服务");
        return new StockServiceCommand(stockServiceFeign).execute();
    }




    public void saveFallback(SaveOrderRequest orderRequest, Throwable e){

        throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
