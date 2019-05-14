package com.study.gc;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {
    /**
     * 内存够用保留，不够 回收
     */
    public static void softRefMemoryEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<Object>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();
        //o1被回收，后面的没有被回收
        System.out.println(o1);
        System.out.println(softReference.get());

    }

    /**
     * JVM配置，故意产生大对象并且配置小内存，让他内存不够用导致OOM，看软引用的回收情况。
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRefMemoryNotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<Object>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());
        o1 = null;
        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Exception e) {

        } finally {
            // null null
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

    public static void main(String[] args) {
        //softRefMemoryEnough();
        softRefMemoryNotEnough();
    }
}
