package com.hujingli.micro.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 扣钱库存请求参数
 */
@ApiModel
@Data
public class MinusStockRequest {

    /**
     * 商品编码
     */
    private String goodsCode;

    /**
     * 商品数量
     */
    private Integer buyNum;
}
