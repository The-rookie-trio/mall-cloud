package com.hujingli.micro.request;

import io.swagger.annotations.ApiModel;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 扣钱库存请求参数
 */
@ApiModel
public class MinusStockRequest {

    /**
     * 商品编码
     */
    private String goodsCode;

    /**
     * 商品数量
     */
    private Integer buyNum;

    public MinusStockRequest() {
    }

    public String getGoodsCode() {
        return this.goodsCode;
    }

    public Integer getBuyNum() {
        return this.buyNum;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MinusStockRequest)) return false;
        final MinusStockRequest other = (MinusStockRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$goodsCode = this.getGoodsCode();
        final Object other$goodsCode = other.getGoodsCode();
        if (this$goodsCode == null ? other$goodsCode != null : !this$goodsCode.equals(other$goodsCode)) return false;
        final Object this$buyNum = this.getBuyNum();
        final Object other$buyNum = other.getBuyNum();
        if (this$buyNum == null ? other$buyNum != null : !this$buyNum.equals(other$buyNum)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MinusStockRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $goodsCode = this.getGoodsCode();
        result = result * PRIME + ($goodsCode == null ? 43 : $goodsCode.hashCode());
        final Object $buyNum = this.getBuyNum();
        result = result * PRIME + ($buyNum == null ? 43 : $buyNum.hashCode());
        return result;
    }

    public String toString() {
        return "MinusStockRequest(goodsCode=" + this.getGoodsCode() + ", buyNum=" + this.getBuyNum() + ")";
    }
}
