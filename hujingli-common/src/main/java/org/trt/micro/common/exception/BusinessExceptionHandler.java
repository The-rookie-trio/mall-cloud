package org.trt.micro.common.exception;

import org.trt.micro.common.rest.response.OneResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * 自定义通用异常处理类
 */
@RestControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public OneResponse handlerHuJingLiException(BusinessException e){
        return new OneResponse<>(e.getCode(), e.getdesc(), e.getData());
    }
}
