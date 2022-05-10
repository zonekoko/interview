package com.zyp.interview.demo.design_pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 10:37
 * @Description TODO
 */
@Component
public class BFileResolve implements FileStrategy{
    @Override
    public FileTypeResolveEnum gainFileType() {
        return FileTypeResolveEnum.File_B_RESOLVE;
    }

    @Override
    public void resolve(Object objectParam) {
        System.out.println("B 类型解析文件");
    }
}
