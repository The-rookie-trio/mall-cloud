package org.trt.micro.filter;

import com.nimbusds.jose.JWSObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.trt.micro.common.constant.AuthConstant;
import org.trt.micro.common.exception.BusinessException;
import reactor.core.publisher.Mono;

import java.text.ParseException;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 19 日
 * @Description gateway全局过滤器  解析jwt 中保存的用户信息
 */
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst(AuthConstant.JWT_TOKEN_HEADER);
        if (StringUtils.isEmpty(token)) {
            // token为空直接放行
            return chain.filter(exchange);
        }
        // 解析用户信息
        String replaceToken = token.replace(AuthConstant.JWT_TOKEN_PREFIX, "");
        try {
            JWSObject parse = JWSObject.parse(replaceToken);
            String userInfo = parse.getPayload().toString();
            log.info("解析请求头中用户信息:[{}]", userInfo);
            ServerHttpRequest request = exchange.getRequest().mutate().header(AuthConstant.JWT_TOKEN_USER_PREFIX, userInfo).build();
            exchange = exchange.mutate().request(request).build();
        } catch (ParseException e) {
            log.error("解析token失败", e);
            throw new BusinessException("解析token失败");
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
