package org.trt.micro.config;

import org.trt.micro.common.constant.AuthConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.trt.micro.auth.DaoUserDetailsService;
import org.trt.micro.jwt.JwtTokenEnhancer;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 15 日
 * @Description oauth2配置文件
 */
@Configuration
@EnableAuthorizationServer
public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenEnhancer tokenEnhancer;
    @Autowired
    private DaoUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    /**
     * 对端点的访问控制
     * ▶ 对oauth/check_token，oauth/token_key访问控制，可以设置isAuthenticated()、permitAll()等权限
     * ▶ 这块的权限控制是针对应用的，而非用户，比如当设置了isAuthenticated()，必须在请求头中添加应用的id和密钥才能访问
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) throws Exception {
        authorizationServerSecurityConfigurer.allowFormAuthenticationForClients();
    }

    /**
     * 此方法主要是用来配置Oauth2中第三方应用的，什么是第三方应用呢，就是请求用微信、微博账号登录的程序
     * ▶ 对于授权码 authorization_code模式，一般使用and().配置多个应用
     * ▶ 可以使用JDBC从数据库读取
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {
        clientDetailsServiceConfigurer.inMemory()
                .withClient(AuthConstant.ADMIN_CLIENT_ID)
                .secret(passwordEncoder.encode(AuthConstant.KEY_PAIR_PWD))
                .authorizedGrantTypes("authorization_code", "refresh_token", "password")
                .scopes("all")
                .accessTokenValiditySeconds(3600 * 24)
                .refreshTokenValiditySeconds(3600 * 24 * 7)
                .and()
                .withClient(AuthConstant.PORTAL_CLIENT_ID)
                .secret(passwordEncoder.encode(AuthConstant.KEY_PAIR_PWD))
                .scopes("all")
                .accessTokenValiditySeconds(3600 * 24)
                .refreshTokenValiditySeconds(3600 * 24 * 7)
        ;

    }

    /**
     * 此配置方法有以下几个用处：
     * 不同的授权类型（Grant Types）需要设置不同的类：
     * authenticationManager：当授权类型为密码模式(password)时，需要设置此类
     * AuthorizationCodeServices： 授权码模式(authorization_code) 下需要设置此类，用于实现授权码逻辑
     * implicitGrantService：隐式授权模式设置此类。
     * tokenGranter：自定义授权模式逻辑
     * <p>
     * 通过pathMapping<默认链接,自定义链接> 方法修改默认的端点URL
     * /oauth/authorize：授权端点。
     * /oauth/token：令牌端点。
     * /oauth/conﬁrm_access：用户确认授权提交端点。
     * /oauth/error：授权服务错误信息端点。
     * /oauth/check_token：用于资源服务访问的令牌解析端点。
     * /oauth/token_key：提供公有密匙的端点，如果你使用JWT令牌的话。
     * <p>
     * <p>
     * 通过tokenStore来定义Token的存储方式和生成方式：
     * InMemoryTokenStore
     * JdbcTokenStore
     * JwtTokenStore
     * RedisTokenStore
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain chain = new TokenEnhancerChain();
        List<TokenEnhancer> enhancers = new ArrayList<>();
        enhancers.add(tokenEnhancer);
        enhancers.add(jwtAccessTokenConverter());
        chain.setTokenEnhancers(enhancers);
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .accessTokenConverter(jwtAccessTokenConverter())
                .tokenEnhancer(chain);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyPair());
        return converter;
    }

    @Bean
    public KeyPair keyPair() {
        // 从classpath 目录下 获取密钥对
        return new KeyStoreKeyFactory(
                new ClassPathResource("jwt.jks"), AuthConstant.KEY_PAIR_PWD.toCharArray())
                .getKeyPair("jwt", AuthConstant.KEY_PAIR_PWD.toCharArray());
    }
}
