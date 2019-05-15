package com.study.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class TestNonBlockingNio {

    public void client() throws Exception {
        //1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //2.切换成非阻塞模式
        socketChannel.configureBlocking(false);
        //3.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //4.发送数据给服务端
        buf.put(new Date().toString().getBytes());
        buf.flip();
        socketChannel.write(buf);
        //关闭通道
        socketChannel.close();
    }

    public void server() throws Exception {
        //1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2.切换成非阻塞模式
        ssChannel.configureBlocking(false);
        //3.绑定连接
        ssChannel.bind(new InetSocketAddress(9898));
        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道注册到选择器上,并且指定“监听事件”
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.轮询式的获取选择器已经“准备就绪”的事件
        while (selector.select() > 0) {
             selector.selectedKeys().iterator();
        }

    }
}
