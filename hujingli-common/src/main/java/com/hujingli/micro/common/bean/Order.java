package com.hujingli.micro.common.bean;

import com.hujingli.micro.common.BaseBean;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 订单实体类
 */
@Data
@Entity
@Table(name = "hujingli_order")
public class Order extends BaseBean {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品编码
     */
    private String goodsCode;

    /**
     * 商品数量
     */
    private Integer bugNum;

    /**
     * 商品名称
     */
    private String goodsName;
}
