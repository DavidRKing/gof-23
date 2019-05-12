package com.study.concurrent;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {
    private volatile Map<String, Object> cache = new HashMap<>();

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();


    public void put(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + "正在写入" + key);
            sleep(300);
            cache.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t" + "写入完成");
        } catch (Exception e) {

        } finally {
            rwLock.writeLock().unlock();
        }


    }

    public Object get(String key) {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t" + "正在读取");
            sleep(300);
            Object result = cache.get(key);
            System.out.println(Thread.currentThread().getName() + "\t" + "读取完成" + result);
            return result;
        } catch (Exception e) {

        } finally {
            rwLock.readLock().unlock();
        }
        return null;
    }

    public static void sleep(int time) {
        try {
            TimeUnit.MICROSECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ReadWriteLockDemo {
}
