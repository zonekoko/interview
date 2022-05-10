package com.zyp.interview.demo.jvm.classLoad;

/**
 * @ClassName NotInitialization
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/2/23 14:42
 * @Version 1.0
 */
public class NotInitialization {

    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}
