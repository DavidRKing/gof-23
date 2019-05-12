package com.study.concurrent;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间按顺序打印，实现A->B->C三个线程启动
 * A打印5次，B打印10次，C打印15次
 * ......
 * 来10轮
 */
class ShareResource {
    private int number = 1;//A:1  B:2  C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() throws Exception {
        lock.lock();
        //1.判断
        while (number != 1) {
            c1.await();
        }
        //2.干活
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
        //3.通知
        number = 2;
        c2.signal();
        lock.unlock();
    }

    public void print10() throws Exception {
        lock.lock();
        //1.判断
        while (number != 2) {
            c2.await();
        }
        //2.干活
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
        //3.通知
        number = 3;
        c3.signal();
        lock.unlock();
    }

    public void print15() throws Exception {
        lock.lock();
        //1.判断
        while (number != 3) {
            c3.await();
        }
        //2.干活
        for (int i = 0; i < 15; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
        //3.通知
        number = 1;
        c1.signal();
        lock.unlock();
    }
}

public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();


        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    resource.print5();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    resource.print10();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();


        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                try {
                    resource.print15();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }
}
