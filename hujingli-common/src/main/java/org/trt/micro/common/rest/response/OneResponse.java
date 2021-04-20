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

    /**
     * 服务器500 返回
     * @param desc 返回描述
     * @return OneResponse
     */
    public static OneResponse error(String desc) {
        return new OneResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), desc);
    }

    /**
     * 用户未认证返回
     * @return OneResponse
     */
    public static OneResponse unauthenticated() {
        return new OneResponse(HttpStatus.UNAUTHORIZED.value(), "请求用户未认证");
    }

    /**
     * 没有权限访问返回
     * @return OneResponse
     */
    public static OneResponse forbidden() {
        return new OneResponse(HttpStatus.FORBIDDEN.value(), "该资源无访问权限");
    }


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
