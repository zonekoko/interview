package com.zyp.interview.demo.design_pattern.strategy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 10:41
 * @Description TODO
 */
@Component
public class StrategyUseService implements ApplicationContextAware {

    private Map<FileTypeResolveEnum,FileStrategy> fileStrategyMap = new ConcurrentHashMap<>();

    //把不同策略放到map
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, FileStrategy> tempMap = applicationContext.getBeansOfType(FileStrategy.class);
        tempMap.values().forEach(fileStrategy -> fileStrategyMap.put(fileStrategy.gainFileType(),fileStrategy));
    }

    public void resolveFile(FileTypeResolveEnum fileTypeResolveEnum,Object objectParam){
        FileStrategy fileStrategy = fileStrategyMap.get(fileTypeResolveEnum);
        if(Objects.nonNull(fileStrategy)){
            fileStrategy.resolve(objectParam);
        }
    }
}
