package com.zyp.interview.demo.jvm.classLoad;

/**
 * @ClassName ConstClass
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/2/23 14:49
 * @Version 1.0
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init");
    }

    public static final String HELLOWORLD = "hello world";
}
