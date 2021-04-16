package org.trt.micro.common.rest.response;

import org.springframework.http.HttpStatus;

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

    public OneResponse(Integer status, String desc) {
        super(status, desc);
    }

    public OneResponse(Integer status, String desc, T t) {
        super(status, desc);
        this.t = t;
    }

    public static OneResponse error(String desc) {
        return new OneResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), desc);
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
