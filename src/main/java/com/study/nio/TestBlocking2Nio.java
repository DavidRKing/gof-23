package com.study.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlocking2Nio {

    public void client() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (inChannel.read(buf) != -1) {
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }
        socketChannel.shutdownOutput();
        //接受客户端的反馈
        int len = 0;
        while ((len = socketChannel.read(buf)) != -1) {
            buf.flip();
            System.out.println(new String(buf.array(), 0, len));
            buf.clear();
        }
        inChannel.close();
        socketChannel.close();
    }

    public void server() throws Exception {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.bind(new InetSocketAddress(9898));
        SocketChannel sChannel = ssChannel.accept();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        FileChannel outChannel = FileChannel.open(Paths.get("2.jgp"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        while (sChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //反馈给客户端
        buf.put("服务端接受收据成功".getBytes());
        buf.flip();
        sChannel.write(buf);

        sChannel.close();
        outChannel.close();
        ssChannel.close();
    }
}
