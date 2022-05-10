package com.zyp.interview.demo.base;

/**
 * @author zyp
 * @Description TODO
 * @Date 2021/11/4 13:21
 */
public class DeadLockDemo {

    private static final String OBJ1 = "obj1";
    private static final String OBJ2 = "obj2";

    public static void main(String[] args) {
        final Thread thread1 = new Thread(new Lock1());
        final Thread thread2 = new Thread(new Lock2());
        thread1.start();
        thread2.start();

    }

    public static class Lock1 implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Lock1 running");
                synchronized (DeadLockDemo.OBJ1) {
                    System.out.println("Lock1 lock obj1");
                    Thread.sleep(50000);
                    synchronized (DeadLockDemo.OBJ2) {
                        System.out.println("lock1 lock obj2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class Lock2 implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Lock2 running");
                synchronized (DeadLockDemo.OBJ2) {
                    System.out.println("Lock2 lock obj2");
                    Thread.sleep(5000);
                    synchronized (DeadLockDemo.OBJ1) {
                        System.out.println("Lock2 lock obj1");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
