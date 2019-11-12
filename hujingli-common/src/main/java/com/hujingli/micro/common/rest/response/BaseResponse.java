package com.hujingli.micro.common.rest.response;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 响应模版的父类
 */
public class BaseResponse {

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 描述
     */
    private String desc;

    public BaseResponse() {
    }

    public BaseResponse(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }
}
