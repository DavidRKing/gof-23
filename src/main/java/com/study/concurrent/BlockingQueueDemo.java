package com.study.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue: 一个基于数结构的有界队列，此队列按照FIFO原则对元素进行排序。
 * LinkedBlockingQueue:一个基于链表结构的阻塞队列，此队列按照FIFO排序元素，吞吐量要高于ArrayBlockingQueue
 * SynchronousQueue:一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，
 * 否则插入操作一致处于阻塞状态，吞吐量通常要高
 * <p>
 * 1.队列
 * 2.阻塞队列
 * 2.1.阻塞队列有没有好的一面
 * <p>
 * 2.2.不得不阻塞，你如何管理
 */
public class BlockingQueueDemo {


    public static void main(String[] args) throws Exception {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //爆出队列满异常
        //System.out.println(blockingQueue.add("d"));


        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //队列空，报异常
        //System.out.println( blockingQueue.remove());


        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        //对了满，返回false
        System.out.println(blockingQueue.offer("x"));
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //队列空，返回null
        System.out.println(blockingQueue.poll());


        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        System.out.println("=======================");
        //队列满了，一直阻塞
        //blockingQueue.put("d");


        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        System.out.println("=====================");
        //blockingQueue.take();

        blockingQueue.offer("a", 2, TimeUnit.SECONDS);
        blockingQueue.offer("a", 2, TimeUnit.SECONDS);
        blockingQueue.offer("a", 2, TimeUnit.SECONDS);
        //阻塞2秒钟
        blockingQueue.offer("a", 2, TimeUnit.SECONDS);

    }
}
