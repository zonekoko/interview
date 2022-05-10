package com.zyp.interview.demo.design_pattern.responsibility_chain;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;


/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 09:33
 * @Description TODO
 */
public abstract class AbstractHandler {

    /** 责任链中的下一个对象 */
    private AbstractHandler nextHandler;

    public void setNextHandler(AbstractHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public AbstractHandler getNextHandler(){
        return nextHandler;
    }


    abstract void doFilter(Request filterRequest,Response response);

    public void filter(Request request, Response response){
        doFilter(request, response);
        if(getNextHandler() != null){
            getNextHandler().filter(request, response);
        }
    }



}


