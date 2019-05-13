package com.study.concurrent;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * thread  runnable callable 线程池
 * 第四种获得/使用java多线程的方式，线程池
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        //一池5个处理线程。
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //一池一线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //一池多线程
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
