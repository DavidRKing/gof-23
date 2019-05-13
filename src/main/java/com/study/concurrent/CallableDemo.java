package com.study.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//class MyThread implements Runnable {
//    public void run() {
//
//    }
//}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("come in callable");
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());
        Thread t1 = new Thread(futureTask, "AA");
        //此时就进入一次，多个线程用给一个futureTask，就算一次
        Thread t2 = new Thread(futureTask, "BB");

        t1.start();
        //阻塞，知道计算结束
        System.out.println(futureTask.get());
        while (!futureTask.isDone()) {
            //判断是否计算完成
        }
    }
}

