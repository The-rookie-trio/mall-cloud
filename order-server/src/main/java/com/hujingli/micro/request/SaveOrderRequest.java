package com.hujingli.micro.request;

import io.swagger.annotations.ApiModel;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 保存订单请求参数
 */
@ApiModel("保存订单请求参数")
public class SaveOrderRequest {

    /**
     * 订单id
     */
    private String orderId;

    public SaveOrderRequest() {
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SaveOrderRequest)) return false;
        final SaveOrderRequest other = (SaveOrderRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$orderId = this.getOrderId();
        final Object other$orderId = other.getOrderId();
        if (this$orderId == null ? other$orderId != null : !this$orderId.equals(other$orderId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SaveOrderRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $orderId = this.getOrderId();
        result = result * PRIME + ($orderId == null ? 43 : $orderId.hashCode());
        return result;
    }

    public String toString() {
        return "SaveOrderRequest(orderId=" + this.getOrderId() + ")";
    }
}
