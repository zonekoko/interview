package com.zyp.interview.demo.myself;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * @ClassName DemoTaskForSemaphore
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/4/18 17:43
 * @Version 1.0
 */
@Slf4j
public class DemoTaskForSemaphore {

    public static void main(String[] args) {

        //A线程的信号量，初始为1
        Semaphore semaphoreA = new Semaphore(1);
        //B线程的信号量，初始为0，阻塞
        Semaphore semaphoreB = new Semaphore(0);
        //C线程的信号量，初始为0，阻塞
        Semaphore semaphoreC = new Semaphore(0);

        for (int j = 0; j < 10; j++) {
            Thread threadA = new Thread(() -> {
                try {
                    semaphoreA.acquire();
                    System.out.print(Thread.currentThread().getName());
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    log.error("#DemoTaskForSemaphore.main error message:", e);
                }
            }, "A");

            Thread threadB = new Thread(() -> {
                try {
                    semaphoreB.acquire();
                } catch (InterruptedException e) {
                    log.error("#DemoTaskForSemaphore.main error message:", e);
                }
                System.out.print(Thread.currentThread().getName());
                semaphoreC.release();
            }, "B");

            Thread threadC = new Thread(() -> {
                try {
                    semaphoreC.acquire();
                } catch (InterruptedException e) {
                    log.error("#DemoTaskForSemaphore.main error message:", e);
                }
                System.out.print(Thread.currentThread().getName());
                semaphoreA.release();
            }, "C");

            threadA.start();
            threadB.start();
            threadC.start();
        }

    }
}
