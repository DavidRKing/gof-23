package com.study.concurrent;

import java.util.concurrent.*;

/**
 * 自定义线程池
 */
public class MyDefineThreadPool {
    public static void main(String[] args) {
//        ExecutorService threadPool = new ThreadPoolExecutor(2,
//                5,
//                1L, TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(3),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());

        //饱和之后， main线程执行
//        ExecutorService threadPool = new ThreadPoolExecutor(2,
//                5,
//                1L, TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(3),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.CallerRunsPolicy());


        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i = 1; i < 11; i++) {
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
