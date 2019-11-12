package com.hujingli.micro.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 保存订单请求参数
 */
@ApiModel("保存订单请求参数")
@Data
public class SaveOrderRequest {

    /**
     * 订单id
     */
    private String orderId;
}
