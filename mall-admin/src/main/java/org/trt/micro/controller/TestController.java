package org.trt.micro.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 21 日
 * @Description 测试Test解扣子
 */
@Slf4j
@RestController
@RequestMapping("/admin/")
public class TestController {


    @GetMapping("/test")
    public String test() {
        log.info("调用api应用test接口");
        return "hello, test";
    }

}

