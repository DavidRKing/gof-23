package com.study.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * java提供了4中引用类型，在来及回收的时候，都有自己各自的特点。
 * ReferenceQueue是用来配合引用工作的，没有ReferenceQueue一样可以运行。
 * <p>
 * 创建引用的时候可以指定关联队列，当GC释放对象内存的时候，会将引用加入到引用队列，
 * 如果程序发现某个虚引用已经被加入到引用队列，那么就可以在所引用的对象的内存被回收之前采取必要的行动。
 * <p>
 * 当关联的引用队列中有数据的时候，意味着引用指向的堆内存中的对象被回收。通过这种方式，
 * JVM允许我们在对象被销毁后，做一些我们自己想做的事情
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        //监控对象的回收信息
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, referenceQueue);
        System.out.println(o1);
        System.out.println(phantomReference.get()); //null
        System.out.println(referenceQueue.poll());  //null
        System.out.println("=======================");


        o1 = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(o1);
        System.out.println(phantomReference.get()); //null
        System.out.println(referenceQueue.poll());  //不是null


    }
}
