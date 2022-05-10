package com.zyp.interview.demo.jvm.classLoad;

/**
 * @ClassName SuperClass
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/2/23 14:38
 * @Version 1.0
 */
public class SuperClass extends SSClass{
    static {
        System.out.println("SuperClass init");
    }

    public static int value = 123;

    public SuperClass(){
        System.out.println("init SuperClass");
    }
}
