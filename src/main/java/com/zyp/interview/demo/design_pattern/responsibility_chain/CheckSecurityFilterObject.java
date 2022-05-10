package com.zyp.interview.demo.design_pattern.responsibility_chain;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 10:03
 * @Description 安全校验对象
 */
@Component
@Order(2)
public class CheckSecurityFilterObject extends AbstractHandler{
    @Override
    void doFilter(Request filterRequest, Response response) {
        System.out.println("安全调用校验");
    }
}
