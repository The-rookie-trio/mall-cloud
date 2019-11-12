package com.hujingli.micro.common.exception;

import com.hujingli.micro.common.rest.response.OneResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 自定义通用异常处理类
 */
@RestControllerAdvice
public class HuJingLiExceptionHandler {

    @ExceptionHandler(HuJingLiException.class)
    public OneResponse handlerHuJingLiException(HuJingLiException e){
        return new OneResponse<>(e.getCode(), e.getdesc(), e.getData());
    }
}
