package com.hujingli.micro.common.exception;

/**
 * @author exphuhong
 * @link{exphuhong@163.com} 通用异常类
 */
public class BusinessException extends RuntimeException {

    private String desc;
    private int code = 500;
    private Object data;

    public BusinessException(String desc) {
        this.desc = desc;
    }

    public BusinessException(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public BusinessException(int code, String desc, Object data) {
        this.desc = desc;
        this.code = code;
        this.data = data;
    }

    public BusinessException(int code, String desc, Throwable e) {
        super(desc, e);
        this.desc = desc;
        this.code = code;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getdesc() {
        return desc;
    }

    public void setdesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CommonException{" +
                "desc='" + desc + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }


}

