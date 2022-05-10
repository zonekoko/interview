package com.zyp.interview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/9/29 10:44
 */
@Configuration
@EnableSwagger2
public class KnifeConfig {

    @Bean
    public Docket create(){
        final Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("进行面试的项目")
                        .contact(new Contact("zyp", "localhost:9000/doc.html", "zyp091922@163.com"))
                        .description("进行面试的项目")
                        .version("1.0.1")
                        .build())
                .groupName("进行面试的项目组")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zyp.interview"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
