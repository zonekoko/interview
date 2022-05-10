package com.zyp.interview.demo.design_pattern.strategy;

import org.springframework.stereotype.Component;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 10:38
 * @Description TODO
 */
@Component
public class DefaultFileResove implements FileStrategy{
    @Override
    public FileTypeResolveEnum gainFileType() {
        return FileTypeResolveEnum.File_DEFAULT_RESOLVE;
    }

    @Override
    public void resolve(Object objectParam) {
        System.out.println("默认类型解析文件");
    }
}
