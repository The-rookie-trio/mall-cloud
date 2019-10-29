package com.hujingli.micro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author exphuhong
 * @link{exphuhong@163.com}
 *
 * swagger2配置
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {

        @Bean
        public Docket customDocket() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any())
                    .build();
        }

        private ApiInfo apiInfo() {
            Contact contact = new Contact("hujingli", "www.xx.xx", "exphuhong@163.com");
            return new ApiInfoBuilder()
                    .title("文档标题")
                    .description("文档描述")
                    .contact(contact)   // 联系方式
                    .version("1.1.0")  // 版本
                    .build();
        }

}
