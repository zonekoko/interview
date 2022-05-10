package com.zyp.interview.demo.design_pattern.responsibility_chain;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 10:05
 * @Description 规则拦截对象
 */
@Component
@Order(4)
public class CheckRuleFilterObject extends AbstractHandler{
    @Override
    void doFilter(Request filterRequest, Response response) {
        System.out.println("check rule");
    }
}
