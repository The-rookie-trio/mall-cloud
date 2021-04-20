package org.trt.micro.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 15 日
 * @Description 获取RSA公钥接口
 */
@Slf4j
@RestController
public class KeyPairController {

    @Autowired
    private KeyPair keyPair;

    /**
     * 网关服务需要RSA的公钥来验证签名是否合法
     *
     * @return key
     */
    @GetMapping("/rsa/publicKey")
    public Map<String, Object> getKey() {
        log.info("获取jwt公钥");
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }


    @GetMapping("test")
    public String test() {
        return "hello";
    }
}
