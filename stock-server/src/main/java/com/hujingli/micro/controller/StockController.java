package com.hujingli.micro.controller;

import com.hujingli.micro.common.rest.BaseController;
import com.hujingli.micro.common.rest.response.BaseResponse;
import com.hujingli.micro.request.MinusStockRequest;
import com.hujingli.micro.service.StockService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 库存接口
 */
@RestController
@RequestMapping("/stock")
@Api(tags = "库存接口")
public class StockController<T> extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StockService stockService;

    @ApiOperation(value = "扣减库存")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "扣减库存成功")
            }
    )
    @PostMapping("/minus")
    public BaseResponse minusStock(@Validated @ApiParam @RequestBody MinusStockRequest stockRequest){

        logger.info("扣减库存，商品代码：{}, 商品数量：{}", stockRequest.getGoodsCode(), stockRequest.getBuyNum());

        stockService.minusStock(stockRequest);

        return successUpdateBaseResponse();
    }

}
