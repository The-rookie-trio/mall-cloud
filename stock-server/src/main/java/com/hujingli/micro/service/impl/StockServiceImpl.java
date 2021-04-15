package com.hujingli.micro.service.impl;

import com.hujingli.micro.common.bean.Stock;
import com.hujingli.micro.common.exception.BusinessException;
import com.hujingli.micro.dao.StockRepository;
import com.hujingli.micro.request.MinusStockRequest;
import com.hujingli.micro.service.StockService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 库存service 业务实现
 */
@Service
public class StockServiceImpl implements StockService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private StockRepository stockRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @HystrixCommand(fallbackMethod = "minusFallback")
    public void minusStock(MinusStockRequest stockRequest) {

        // 查看库存是否足够
        Stock totalStock = stockRepository.findStockByGoodsCode(stockRequest.getGoodsCode());
        if (totalStock.getGoodsQuantity() >= stockRequest.getBuyNum()) { // 满足要求可以购买
            // TODO: 2019/11/12 这里暂不考虑并发情况，如若要考虑使用 并发则可以添加一个乐观锁（版本号）
            totalStock.setGoodsQuantity(totalStock.getGoodsQuantity() - stockRequest.getBuyNum());
        }

    }

    public void minusFallback(){
        logger.debug("库存扣减服务容错保护触发，返回错误信息");
        throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器异常");
    }
}
