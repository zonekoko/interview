package com.zyp.interview.demo.design_pattern.responsibility_chain;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 10:02
 * @Description 参数校验对象
 */
@Component
@Order(1)
public class CheckParamFilterObject extends AbstractHandler{
    @Override
    void doFilter(Request filterRequest, Response response) {
        System.out.println("非空参数校验");
    }
}
