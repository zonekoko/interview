package com.zyp.interview.demo.design_pattern.responsibility_chain;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 10:06
 * @Description TODO
 */
@Component("chainPatternDemo")
public class ChainPatternDemo {

    /** 自动注入各个责任链的对象 */
    @Autowired
    private List<AbstractHandler> abstractHandlerList;

    private AbstractHandler abstractHandler;

    /** spring注入后自动执行，责任链的对象连接起来 */
    @PostConstruct
    public void initializeChainFilter(){
        for (int i = 0; i < abstractHandlerList.size(); i++) {
            if(i == 0){
                abstractHandler = abstractHandlerList.get(0);
            }else{
                AbstractHandler currentHandler = abstractHandlerList.get(i - 1);
                AbstractHandler nextHandler = abstractHandlerList.get(i);
                currentHandler.setNextHandler(nextHandler);
            }
        }
    }

    public AbstractHandler getAbstractHandler(){
        return abstractHandler;
    }

    public void setAbstractHandler(AbstractHandler abstractHandler){
        this.abstractHandler = abstractHandler;
    }

    public Response exec(Request request,Response response){
        abstractHandler.filter(request,response);
        return response;
    }
}
