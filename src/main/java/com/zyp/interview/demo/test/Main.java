package com.zyp.interview.demo.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10, true),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        List<Future<String>> futureList = new ArrayList<>();
//
//        System.out.println("开始通知大家去聚餐");
//        Future<String> future10 = threadPoolExecutor.submit(() -> {
//            System.out.println("这是领导，领导说我要等10分钟");
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                System.out.println("领导出错了");
//            }
//            System.out.println("领导说我等好了");
//            return "领导";
//        });
//        futureList.add(future10);
//
//        Future<String> future3 = threadPoolExecutor.submit(() -> {
//            System.out.println("这是小兵，小兵说我要等3分钟");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                System.out.println("小兵出错了");
//            }
//            System.out.println("小兵说我等好了");
//            return "小兵";
//        });
//        futureList.add(future3);
//
//        Future<String> future6 = threadPoolExecutor.submit(() -> {
//            System.out.println("这是小领导，小领导说我要等6分钟");
//            try {
//                Thread.sleep(6000);
//            } catch (InterruptedException e) {
//                System.out.println("小领导出错了");
//            }
//            System.out.println("小领导说我等好了");
//            return "小领导";
//        });
//
//        futureList.add(future6);
//
//        for (int i = 0; i < futureList.size(); i++) {
//            System.out.println("我现在去接" + futureList.get(i).get() + "了");
//        }
//        threadPoolExecutor.shutdown();

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
