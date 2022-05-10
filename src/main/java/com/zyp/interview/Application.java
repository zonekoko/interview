package com.zyp.interview;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/9/29 10:42
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zyp.interview.mapper")
@EnableSwagger2
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
