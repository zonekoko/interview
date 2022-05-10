package com.zyp.interview.demo.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName ExecutorCompletionServiceDemo
 * @Description TODO
 * @Author zhangyanping
 * @Date 2022/4/29 14:48
 * @Version 1.0
 */
public class ExecutorCompletionServiceDemo {

    public static void main(String[] args) {
//        try {
//            threadPoolExecutorDemo();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            executorCompletionServiceDemo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static void threadPoolExecutorDemo() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10, true),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        List<Future<String>> futureList = new ArrayList<>();

        System.out.println("开始通知大家去聚餐");
        Future<String> future10 = threadPoolExecutor.submit(() -> {
            System.out.println("这是领导，领导说我要等10分钟");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("领导出错了");
            }
            System.out.println("领导说我等好了");
            return "领导";
        });
        futureList.add(future10);

        Future<String> future3 = threadPoolExecutor.submit(() -> {
            System.out.println("这是小兵，小兵说我要等3分钟");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("小兵出错了");
            }
            System.out.println("小兵说我等好了");
            return "小兵";
        });
        futureList.add(future3);

        Future<String> future6 = threadPoolExecutor.submit(() -> {
            System.out.println("这是小领导，小领导说我要等6分钟");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                System.out.println("小领导出错了");
            }
            System.out.println("小领导说我等好了");
            return "小领导";
        });

        futureList.add(future6);

        for (int i = 0; i < futureList.size(); i++) {
            System.out.println("我现在去接" + futureList.get(i).get() + "了");
        }
        threadPoolExecutor.shutdown();
    }

    private static void executorCompletionServiceDemo() throws InterruptedException, ExecutionException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10, true),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        List<Future<String>> futureList = new ArrayList<>();
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(threadPoolExecutor);
        Future<String> future10 = completionService.submit(() -> {
            System.out.println("这是领导，领导说我要等10分钟");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("领导出错了");
            }
            System.out.println("领导说我等好了");
            return "领导";
        });
        futureList.add(future10);

        Future<String> future3 = completionService.submit(() -> {
            System.out.println("这是小兵，小兵说我要等3分钟");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("小兵出错了");
            }
            System.out.println("小兵说我等好了");
            return "小兵";
        });
        futureList.add(future3);

        Future<String> future6 = completionService.submit(() -> {
            System.out.println("这是小领导，小领导说我要等6分钟");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                System.out.println("小领导出错了");
            }
            System.out.println("小领导说我等好了");
            return "小领导";
        });
        futureList.add(future6);

        for (int i = 0; i < futureList.size(); i++) {
            System.out.println("我现在去接" + completionService.take().get() + "了");
        }

        threadPoolExecutor.shutdown();
    }
}
