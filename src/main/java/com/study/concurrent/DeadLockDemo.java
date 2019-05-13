package com.study.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 死锁是指两个或两个以上的进程在执行过程中，
 * 因争夺资源而造成的一种互相等待的现象。
 * 若无外力干涉那他们都将无法推进下去。
 */
class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t自己持有" + lockA + "\t尝试获取:" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t自己持有" + lockB + "\t尝试获取:" + lockA);
            }
        }
    }
}


public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "Thread-A").start();
        new Thread(new HoldLockThread(lockB, lockA), "Thread-B").start();

        //jps 查看java进程
        //linux  ps -ef | grep xxx
        //windows下的java运行程序  jsp -l
    }
}

