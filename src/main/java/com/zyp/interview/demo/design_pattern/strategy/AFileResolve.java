package com.zyp.interview.demo.design_pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 10:36
 * @Description TODO
 */
@Component
public class AFileResolve implements FileStrategy{
    @Override
    public FileTypeResolveEnum gainFileType() {
        return FileTypeResolveEnum.File_A_RESOLVE;
    }

    @Override
    public void resolve(Object objectParam) {
        System.out.println("A 类型解析文件");
        //TODO 具体逻辑
    }
}
