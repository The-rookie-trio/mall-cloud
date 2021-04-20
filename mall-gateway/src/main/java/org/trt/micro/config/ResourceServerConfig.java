package org.trt.micro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.trt.micro.authorization.AuthorizationManager;
import org.trt.micro.component.AuthenticationEntryPoint;
import org.trt.micro.component.RestfulAccessDeniedHandler;
import reactor.core.publisher.Mono;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 19 日
 * @Description 资源服务器配置
 */
@EnableWebFluxSecurity
@Configuration
public class ResourceServerConfig {

    @Autowired
    private AuthorizationManager authorizationManager;

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private RestfulAccessDeniedHandler accessDeniedHandler;

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthenticationConverter());  // jwt解析
        //自定义处理JWT请求头过期或签名错误的结果
        httpSecurity.oauth2ResourceServer().authenticationEntryPoint(authenticationEntryPoint);
        httpSecurity.authorizeExchange()
                .pathMatchers(ignoreUrlsConfig.toStringArray()).permitAll() //白名单
                .anyExchange().access(authorizationManager)  // 鉴权管理器
                .and().exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler) // 处理未授权的
                .authenticationEntryPoint(authenticationEntryPoint) // 处理未认证
                .and().csrf().disable()
                ;
        return httpSecurity.build();

    }

    @Bean
    public Converter<Jwt, ? extends Mono<? extends AbstractAuthenticationToken>> jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix(""); // 角色前缀
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
    }

}
