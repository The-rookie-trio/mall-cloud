package com.hujingli.micro.controller;

import com.hujingli.common.rest.BaseController;
import com.hujingli.common.rest.response.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
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

    @ApiOperation(value = "扣减库存")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "扣减库存成功")
            }
    )
    @PutMapping("/")
    public BaseResponse minusStock(){

        logger.info("");

        return successUpdateBaseResponse();
    }

}
