package com.hujingli.micro.service;

import com.hujingli.micro.request.MinusStockRequest;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 库存service接口
 */
public interface StockService {

    /**
     * 扣减库存
     * @param stockRequest 扣减库存请求参数
     */
    void minusStock(MinusStockRequest stockRequest);
}
