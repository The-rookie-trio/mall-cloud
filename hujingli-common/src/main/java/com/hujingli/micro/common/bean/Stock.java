package com.hujingli.micro.common.bean;

import com.hujingli.micro.common.BaseBean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 库存实体类
 */
@Entity
@Table(name = "hujingli_stock")
public class Stock extends BaseBean {

    /**
     * 商品编码
     */
    private String goodsCode;

    /**
     * 商品数量
     */
    private Integer goodsQuantity;

    /**
     * 商品名称
     */
    private String goodsName;

    public Stock() {
    }


    public String getGoodsCode() {
        return this.goodsCode;
    }

    public Integer getGoodsQuantity() {
        return this.goodsQuantity;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public void setGoodsQuantity(Integer goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Stock)) return false;
        final Stock other = (Stock) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$goodsCode = this.getGoodsCode();
        final Object other$goodsCode = other.getGoodsCode();
        if (this$goodsCode == null ? other$goodsCode != null : !this$goodsCode.equals(other$goodsCode)) return false;
        final Object this$goodsQuantity = this.getGoodsQuantity();
        final Object other$goodsQuantity = other.getGoodsQuantity();
        if (this$goodsQuantity == null ? other$goodsQuantity != null : !this$goodsQuantity.equals(other$goodsQuantity))
            return false;
        final Object this$goodsName = this.getGoodsName();
        final Object other$goodsName = other.getGoodsName();
        if (this$goodsName == null ? other$goodsName != null : !this$goodsName.equals(other$goodsName)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Stock;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $goodsCode = this.getGoodsCode();
        result = result * PRIME + ($goodsCode == null ? 43 : $goodsCode.hashCode());
        final Object $goodsQuantity = this.getGoodsQuantity();
        result = result * PRIME + ($goodsQuantity == null ? 43 : $goodsQuantity.hashCode());
        final Object $goodsName = this.getGoodsName();
        result = result * PRIME + ($goodsName == null ? 43 : $goodsName.hashCode());
        return result;
    }

    public String toString() {
        return "Stock(goodsCode=" + this.getGoodsCode() + ", goodsQuantity=" + this.getGoodsQuantity() + ", goodsName=" + this.getGoodsName() + ")";
    }
}
