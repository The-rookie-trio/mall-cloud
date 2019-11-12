package com.hujingli.micro.common.rest;

import com.hujingli.micro.common.rest.response.BaseResponse;
import org.springframework.http.HttpStatus;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 所有的controller的父类
 */
public class BaseController {

    // TODO: 2019/10/30 提供 一些模版响应方法

    /**
     * 保存成功响应
     */
    public BaseResponse successSaveBaseResponse(){
        return new BaseResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    /**
     * 修改成功响应
     */
    public BaseResponse successUpdateBaseResponse(){
        return new BaseResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }
}
