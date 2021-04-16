package org.trt.micro.common.bean;

import org.trt.micro.common.BaseBean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 订单实体类
 */
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

    public Order() {
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getGoodsCode() {
        return this.goodsCode;
    }

    public Integer getBugNum() {
        return this.bugNum;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public void setBugNum(Integer bugNum) {
        this.bugNum = bugNum;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Order)) return false;
        final Order other = (Order) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$orderId = this.getOrderId();
        final Object other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !this$orderId.equals(other$orderId)) return false;
        final Object this$goodsCode = this.getGoodsCode();
        final Object other$goodsCode = other.getGoodsCode();
        if (this$goodsCode == null ? other$goodsCode != null : !this$goodsCode.equals(other$goodsCode)) return false;
        final Object this$bugNum = this.getBugNum();
        final Object other$bugNum = other.getBugNum();
        if (this$bugNum == null ? other$bugNum != null : !this$bugNum.equals(other$bugNum)) return false;
        final Object this$goodsName = this.getGoodsName();
        final Object other$goodsName = other.getGoodsName();
        if (this$goodsName == null ? other$goodsName != null : !this$goodsName.equals(other$goodsName)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Order;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $orderId = this.getOrderId();
        result = result * PRIME + ($orderId == null ? 43 : $orderId.hashCode());
        final Object $goodsCode = this.getGoodsCode();
        result = result * PRIME + ($goodsCode == null ? 43 : $goodsCode.hashCode());
        final Object $bugNum = this.getBugNum();
        result = result * PRIME + ($bugNum == null ? 43 : $bugNum.hashCode());
        final Object $goodsName = this.getGoodsName();
        result = result * PRIME + ($goodsName == null ? 43 : $goodsName.hashCode());
        return result;
    }

    public String toString() {
        return "Order(orderId=" + this.getOrderId() + ", goodsCode=" + this.getGoodsCode() + ", bugNum=" + this.getBugNum() + ", goodsName=" + this.getGoodsName() + ")";
    }
}
