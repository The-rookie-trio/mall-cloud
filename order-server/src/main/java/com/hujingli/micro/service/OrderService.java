package com.hujingli.micro.service;

import com.hujingli.micro.common.rest.response.BaseResponse;
import com.hujingli.micro.request.SaveOrderRequest;
import com.hujingli.micro.response.SaveOrderVO;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 订单接口
 */
public interface OrderService {

    void save(SaveOrderRequest orderRequest);

    BaseResponse testFeign();
}
