package com.hujingli.micro.dao;

import com.hujingli.micro.common.bean.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, String> {

    Stock findStockByGoodsCode(String goodsCode);
}
