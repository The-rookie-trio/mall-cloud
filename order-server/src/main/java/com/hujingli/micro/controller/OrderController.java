package com.hujingli.micro.controller;

import com.hujingli.micro.common.rest.BaseController;
import com.hujingli.micro.common.rest.response.BaseResponse;
import com.hujingli.micro.request.SaveOrderRequest;
import com.hujingli.micro.service.OrderService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author exphuhong
 * @link{exphuhong@163.com} 订单controller
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单接口")
public class OrderController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private DiscoveryClient client;
    @Resource
    private OrderService orderService;


    /**
     * 保存订单
     */
    @ApiOperation(value = "保存订单",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message="保存订单成功")
    })
    @PostMapping("/save")
    public BaseResponse saveOrder(@Validated @ApiParam @RequestBody SaveOrderRequest orderRequest){

        logger.info("保存订单，订单号：{}", orderRequest.getOrderId());

        orderService.save(orderRequest);

        logger.info("保存订单成功，订单号：{}", orderRequest.getOrderId());
        return successSaveBaseResponse();
    }


    /**
     * 测试feign
     */
    @GetMapping("testFeign")
    public BaseResponse testFeign(){
        logger.info("测试feign是否可用，进入order服务");

        return orderService.testFeign();

    }
}

