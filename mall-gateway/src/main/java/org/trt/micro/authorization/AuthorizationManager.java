package org.trt.micro.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.trt.micro.common.constant.AuthConstant;
import org.trt.micro.config.IgnoreUrlsConfig;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 19 日
 * @Description 鉴权管理器
 */
@Component
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        // 跨域预检请求直接放行
        if (request.getMethod() == HttpMethod.OPTIONS) {
            return Mono.just(new AuthorizationDecision(true));
        }
        PathMatcher matcher = new AntPathMatcher();

        // 白名单直接放行

        Map<Object, Object> resourceMap = redisTemplate.opsForHash().entries(AuthConstant.ROLES_RESOURCE_MAP);
        // 获取所有的资源 角色关系
        List<String> authorities = new ArrayList<>();
        URI uri = request.getURI();
        resourceMap.forEach((k, v) -> {
            if (matcher.match((String) k, uri.getPath())) {
                // 匹配上了，加入角色信息
                authorities.addAll((Collection<? extends String>) v);
            }
        });

        return mono.filter(item->{
            System.out.println(item.getAuthorities()+"----------");
            System.out.println(item.getPrincipal());
            return item.isAuthenticated();
        })
                .flatMapIterable(Authentication::getAuthorities)
                .map(item->{
                    System.out.println("用户角色：" + item.getAuthority());
                    return item.getAuthority();
                })
                .any(authorities::contains)
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false))
                ;

    }
}
