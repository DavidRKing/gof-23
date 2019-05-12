package com.study.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {


    public static void closeDoor() {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t***********关门走人");
    }


    public static void main(String[] args) {
        closeDoor();
    }


}
