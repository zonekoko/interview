package com.zyp.interview.demo.design_pattern.responsibility_chain;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 10:04
 * @Description 黑名单校验对象
 */
@Component
@Order(3)
public class CheckBlackFilterObject extends AbstractHandler{
    @Override
    void doFilter(Request filterRequest, Response response) {
        System.out.println("校验黑名单");
    }
}
