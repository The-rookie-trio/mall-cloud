package org.trt;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.trt.micro.AuthApplication;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 16 日
 * @Description
 */
@SpringBootTest(classes = AuthApplication.class)
@RunWith(SpringRunner.class)
public class Test {

    @Autowired
    PasswordEncoder passwordEncoder;

    @org.junit.Test
    public void test() {
        String admin = passwordEncoder.encode("admin");
        System.out.println(admin);
    }

}
