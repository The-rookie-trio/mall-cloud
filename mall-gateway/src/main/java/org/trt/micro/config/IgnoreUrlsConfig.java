package org.trt.micro.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2021 年 04 月 19 日
 * @Description 白名单配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "secure.ignore")
public class IgnoreUrlsConfig {

    /**
     * 白名单资源url
     */
    private List<String> urls = new ArrayList<>();

    /**
     * urls转换为String 数组
     * @return String[]
     */
    public String[] toStringArray() {
        String[] ignoreUrls = new String[this.urls.size()];
        for (int i = 0; i < this.urls.size(); i++) {
            ignoreUrls[i] = this.urls.get(i);
        }
        return ignoreUrls;
    }

}
