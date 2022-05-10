package com.zyp.interview.demo.design_pattern.strategy;

/**
 * @author zyp
 * @version V1.0
 * @Date 2022/1/19 10:27
 * @Description TODO
 */
public interface FileStrategy {

    /** 属于哪种文件解析类型 */
    FileTypeResolveEnum gainFileType();

    /** 封装的公用算法（具体的解析方法） */
    void resolve(Object objectParam);




}
