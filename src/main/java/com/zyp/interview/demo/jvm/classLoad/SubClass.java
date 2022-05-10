package com.zyp.interview.demo.jvm.classLoad;

/**
 * @ClassName SubClass
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/2/23 14:41
 * @Version 1.0
 */
public class SubClass extends SuperClass{

    static {
        System.out.println("SubClass init");
    }

    static int a ;

    public SubClass(){
        System.out.println("init SubClass");
    }
}
