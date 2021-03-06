package com.zyp.interview.demo.myself;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName DemoTaskForReentrantLock
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/4/18 17:11
 * @Version 1.0
 */
public class DemoTaskForReentrantLock {

    public static void main(String[] args) {
        demo();
    }

    private static void demo(){
        ReentrantLock lock = new ReentrantLock(false);
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        new Thread(()->{
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print(Thread.currentThread().getName());
                    conditionB.signal();
                    conditionA.await();
                }
                conditionB.signal();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        },"A").start();

        new Thread(()->{
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print(Thread.currentThread().getName());
                    conditionC.signal();
                    conditionB.await();
                }
                conditionC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"B").start();

        new Thread(()->{
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    System.out.print(Thread.currentThread().getName());
                    conditionA.signal();
                    conditionC.await();
                }
                conditionA.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"C").start();

    }
}
