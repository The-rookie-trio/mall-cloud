package com.hujingli.micro.response;

import io.swagger.annotations.ApiModel;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 保存订单请求响应
 */
@ApiModel
public class SaveOrderVO {


    public SaveOrderVO() {
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SaveOrderVO)) return false;
        final SaveOrderVO other = (SaveOrderVO) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SaveOrderVO;
    }

    public int hashCode() {
        int result = 1;
        return result;
    }

    public String toString() {
        return "SaveOrderVO()";
    }
}
