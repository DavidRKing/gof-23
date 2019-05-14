package com.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一、使用NIO完成网络通信的三个核心
 * 1.通道（Channel）：负责连接
 * java.nio.channels.Channel
 * SeletableChannel
 * SocketChannel        TCP
 * ServerSocketChannel  UDP
 * DatagramChannel      UDP
 * 没有FileChannel 因为 FileChinnel不能切换为非阻塞模式
 * 2.缓冲区（Buffer）：负责数据存取
 * 3.选择器(Selector):是SelectableChannel的多路复用器。
 * 用于监控SelectableChannel的IO状况
 */
public class TestBlockingNio {

    public void client() throws IOException {
        //1.获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //2.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //3.读取本地文件，并发送到服务端去
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        while (inChannel.read(buf) != -1) {
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        inChannel.close();
        sChannel.close();
    }

    public void server() throws Exception {
        //1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2.绑定连接
        ssChannel.bind(new InetSocketAddress(9898));
        //3.获取客户端连接
        SocketChannel socketChannel = ssChannel.accept();
        //4.接受客户端的数据，并保存到本地
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (socketChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }
        socketChannel.close();
        outChannel.close();
        outChannel.close();
    }

    public static void main(String[] args) {

    }

}
