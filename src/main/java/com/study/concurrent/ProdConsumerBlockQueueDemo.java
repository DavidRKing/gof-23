package com.study.concurrent;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    private volatile boolean FLAG = true;//默认开启，进行生产+消费
    //生产，消费，的数据
    private AtomicInteger atomicInteger = new AtomicInteger();
    //依赖接口，外界想用任何 阻塞队列都可以
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data);
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\tFLAG=false，生产动作结束");
    }

    public void myConsumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t超过2秒钟没有取到数据，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + "成功");
        }
    }

    public void stop() {
        FLAG = false;
    }


}

/**
 * volatile/cas/atomicInteger/BlockQueue/线程交互/原子引用
 */
public class ProdConsumerBlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t成产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        TimeUnit.SECONDS.sleep(5);
        myResource.stop();
        System.out.println("5秒钟时间到，消费者，生产者结束");
    }
}
