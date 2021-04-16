package org.trt.micro.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.trt.micro.common.constant.AuthConstant;
import org.trt.micro.common.rest.response.OneResponse;
import org.trt.micro.dto.Oauth2TokenVO;

import java.security.Principal;
import java.util.Map;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 16 日
 * @Description 认证获取token
 */
@Slf4j
@RestController
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    TokenEndpoint tokenEndpoint;

    @PostMapping("/token")
    public OneResponse<Oauth2TokenVO> postAccessToken(Principal principal, @RequestParam Map<String, String> params) throws HttpRequestMethodNotSupportedException {
        log.info("认证服务，获取token令牌:[{}]", principal);
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, params).getBody();
        Oauth2TokenVO oauth2TokenVO = new Oauth2TokenVO();
        oauth2TokenVO.setToken(oAuth2AccessToken.getValue());
        oauth2TokenVO.setExpiresIn(oAuth2AccessToken.getExpiresIn());
        oauth2TokenVO.setRefreshToken(oAuth2AccessToken.getRefreshToken().getValue());
        oauth2TokenVO.setTokenHead(AuthConstant.JWT_TOKEN_PREFIX);
        log.info("认证成功，获取token成功:[{}]", oauth2TokenVO);
        return new OneResponse<>(HttpStatus.OK.value(), "获取token成功", oauth2TokenVO);
    }
}
