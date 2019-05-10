package com.study.nio;

import java.nio.ByteBuffer;

/**
 * 各种缓冲区
 * ByteBuffer
 * CharBuffer
 * ....
 * DoubleBuffer
 * <p>
 * 上述缓冲区中的管理方式几乎一致，通过allocate()获取缓冲区
 * 二、缓冲区存取数据的两个核心方法
 * put（）：存入数据到缓冲区中
 * get();获取缓冲区中的数据
 * 三、缓冲区中的四个核心属性 ：
 * capacity;容量，表示缓冲区中最大存储数据的容量，一旦声明不能改变
 * limit:界限，表示缓冲区中可以操作数据的大小，(limit 后数据不能进行读取)
 * position:位置，表示缓冲区中正在操作的数据位置
 * <p>
 * 0<=mark<=position<=limit<=capacity
 */
public class TestBuffer {

    public void test2() {
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        buffer.flip();
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst, 0, 2);
        System.out.println(new String(dst, 0, 2));
        System.out.println(buffer.position());
        //mark() 标记
        buffer.mark();
        buffer.get(dst, 2, 2);

        System.out.println(new String(dst, 2, 2));
        System.out.println(buffer.position());
        //reset():恢复到mark的位置
        buffer.reset();
        System.out.println(buffer.position());

    }

    public void test1() {
        //1.分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.capacity()); //1024
        System.out.println(buffer.limit()); //1024
        System.out.println(buffer.position()); //0

        //2.利用put()存入数据到缓冲区
        String str = "abcde";
        buffer.put(str.getBytes());
        System.out.println("put-----------------");
        System.out.println(buffer.capacity()); //1024
        System.out.println(buffer.limit()); //1024
        System.out.println(buffer.position()); //5

        //3.切换成读取数据模式
        buffer.flip();
        System.out.println("get------------------");
        System.out.println(buffer.capacity()); //1024
        System.out.println(buffer.limit()); //5
        System.out.println(buffer.position()); //5

        //4.利用get()读取缓冲区中的数据
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst, 0, dst.length));
        System.out.println(buffer.capacity()); //1024
        System.out.println(buffer.limit()); //5
        System.out.println(buffer.position()); //5

        //5.rewind();可重复读数据
        buffer.rewind();
        System.out.println(buffer.capacity()); //1024
        System.out.println(buffer.limit()); //5
        System.out.println(buffer.position()); //0

        //6.clear()清空缓冲区,但是缓冲区中的数据依然存在，但是处于"被遗忘"状态
        buffer.clear();
        System.out.println(buffer.capacity()); //1024
        System.out.println(buffer.limit()); //1024
        System.out.println(buffer.position()); //0


    }

    public static void main(String[] args) {
        TestBuffer testBuffer = new TestBuffer();
        testBuffer.test1();
    }
}
