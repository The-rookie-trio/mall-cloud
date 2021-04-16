package org.trt.micro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.trt.micro.common.rest.response.OneResponse;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 16 日
 * @Description 认证异常统一处理
 */
@RestControllerAdvice
public class Oauth2ExceptionHandler {

    @ExceptionHandler(value = OAuth2Exception.class)
    public OneResponse exceptionHandler(OAuth2Exception e) {
        e.printStackTrace();
        return OneResponse.error(e.getMessage());
    }
}
