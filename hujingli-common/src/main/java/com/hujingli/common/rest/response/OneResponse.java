package com.hujingli.common.rest.response;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 响应模版
 */
public class OneResponse<T> extends BaseResponse {

    /**
     * 响应实体数据
     */
    private T t;

    public OneResponse(Integer status, String desc, T t) {
        super(status, desc);
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
