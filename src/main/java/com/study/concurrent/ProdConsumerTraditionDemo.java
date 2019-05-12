package com.study.concurrent;

/**
 * 生产者消费者，传统版
 * 一个初始值为0的变量，连个线程对其交替操作，一个加1一个减1，来5轮
 * <p>
 * 1 线程   操作（方法）  资源类
 * 2 判断   干活   通知
 * 3 防止虚假唤醒机制
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        try {
            //1.判断
            lock.lock();
            while (number != 0) {
                //等待,不能生产
                condition.await();
            }
            //2.干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void decrement() throws Exception {
        try {
            //1.判断
            lock.lock();
            while (number == 0) {
                //等待,不能生产
                condition.await();
            }
            //2.干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

public class ProdConsumerTraditionDemo {


    public static void main(String[] args) {
        ShareData data = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    data.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();


        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    data.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
    }
}
