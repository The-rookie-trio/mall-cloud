package com.hujingli.micro.service;

import com.hujingli.micro.common.rest.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 使用feign进行远程服务调用
 */
@FeignClient("stock")
public interface StockServiceFeign {



    @GetMapping("/stock/testFeign") // 使用mvc的注解形式来绑定远程服务的接口
    BaseResponse minus();
}
