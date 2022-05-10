package com.zyp.interview.demo.myself;

import javax.management.ObjectName;

/**
 * @ClassName DemoTask1
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/4/18 16:49
 * @Version 1.0
 */
public class DemoTaskForSynchronized {

    private static boolean flagA = true;
    private static boolean flagB = false;
    private static boolean flagC = false;


    public static void main(String[] args) {
        demo1();
    }

    private static void demo1(){
        Object lock = new Object();
        new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 10;) {
                    if(flagA){
                        System.out.print(Thread.currentThread().getName());
                        flagA = false;
                        flagB = true;
                        flagC = false;
                        lock.notifyAll();
                        i++;
                    }else {
                        //说明没有轮到当前线程
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        },"A").start();
        new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 10; ) {
                    if(flagB){
                        System.out.print(Thread.currentThread().getName());
                        flagA = false;
                        flagB = false;
                        flagC = true;
                        lock.notifyAll();
                        i++;
                    }else {
                        //说明没有轮到当前线程
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        },"B").start();
        new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 10; ) {
                    if(flagC){
                        System.out.print(Thread.currentThread().getName());
                        flagA = true;
                        flagB = false;
                        flagC = false;
                        lock.notifyAll();
                        i++;
                    }else {
                        //说明没有轮到当前线程
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        },"C").start();
    }
}
