package com.zyp.interview.demo.jvm.classLoad;

/**
 * @ClassName TestClassLoaderPath
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/2/23 15:40
 * @Version 1.0
 */
public class TestClassLoaderPath {

    public static void main(String[] args) {
        //Bootstrap ClassLoader加载的文件
        System.out.println(System.getProperty("sun.boot.class.path"));

        //ExtClassLoader加载的文件
        System.out.println(System.getProperty("java.ext.dirs"));

        //AppClassLoader加载的文件
        System.out.println(System.getProperty("java.class.path"));
    }
}
