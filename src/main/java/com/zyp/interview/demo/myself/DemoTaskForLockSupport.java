package com.zyp.interview.demo.myself;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName DemoTask
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/4/18 16:02
 * @Version 1.0
 */
public class DemoTaskForLockSupport {

    private static Thread threadA;
    private static Thread threadB;
    private static Thread threadC;



    public static void main(String[] args) {
        demo1();
    }

    public static void demo1(){

        threadA =  new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.print(Thread.currentThread().getName());
                LockSupport.unpark(threadB);
                LockSupport.park();
            }
        },"AAA");

        threadB =  new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.print(Thread.currentThread().getName());
                LockSupport.unpark(threadC);
            }
        },"BBB");

        threadC =  new Thread(()->{
            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                System.out.print(Thread.currentThread().getName());
                LockSupport.unpark(threadA);
            }
        },"CCC");

        threadA.start();
        threadB.start();
        threadC.start();
    }


}
