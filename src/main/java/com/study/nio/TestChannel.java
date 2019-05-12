package com.study.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

/**
 * 一、通道（Channel）：用于源节点与目标节点的连接。
 * 在JAVA NIO中负责缓冲区中数据的传输
 * Channel本身不存储数据，因此需要配合缓冲区进行传输
 * 二、通道的主要实现类
 * java.nio.channels.Channel接口:
 * --FileChannel       (文件)
 * --SocketChannel    (TCP)
 * --ServerSocketChannel (TCP)
 * --DatagramChannel  (UDP)
 * <p>
 * 三、获取通道
 * 1.Java针对支持通道的类提供了getChannel()方法
 * 本地IO:
 * FileInputStream/FileOutputStream
 * RandomAccessFile
 * 网络IO
 * Socket
 * ServerSocket
 * DatagramSocket
 * <p>
 * 2.在JDK1.7中NIO.2 针对各个通道提供了静态方法open()
 * <p>
 * 3.在JDK1.7中NIO.2 Files工具类 newByteChannel()
 * <p>
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 * 五、分散（scatter） 与聚集 （gather）
 * 分散读取（scatter reader）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（gathering writes）：将多个缓冲区中的数据聚集到通道中
 * <p>
 * 六、字符集Charset
 * <p>
 * 编码：字符串--->字节数组
 * 解码: 字节数组---->字符串
 */
public class TestChannel {


    //1.利用通道完成文件的复制
    public void test1() throws Exception {
        FileInputStream fis = new FileInputStream("");
        FileOutputStream fos = new FileOutputStream("");
        //2.获取通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        //3.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //4.将通道中的数据存入缓冲区中
        while (inChannel.read(buf) != -1) {
            buf.flip();//切换读取数据模式
            //将缓冲区数据写入通道中
            outChannel.write(buf);
            //清空缓冲区
            buf.clear();
        }
        //最后各种关闭
    }

    //2.使用直接缓冲区完成文件的复制(内存映射文件)
    //写文件速度非常快，但是不稳定，
    public void test2() throws Exception {

        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);

        //内存映射文件  allocateDirect() 原理一样，获取方式不一样.直接在物理内存中
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        //这个不需要通道，直接操作缓冲区。进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        //数据从inMappedBuf读到dst 中
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();
    }

    //通道之间的数据传输(直接缓冲区的方式)
    public void test3() throws Exception {
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
        inChannel.transferTo(0, inChannel.size(), outChannel);
        inChannel.close();
        outChannel.close();
    }

    /**
     * 分散和聚集写入
     *
     * @throws Exception
     */
    public void test4() throws Exception {
        RandomAccessFile raf1 = new RandomAccessFile("1.txt", "rw");
        //1.获取通道
        FileChannel channel1 = raf1.getChannel();
        //2.分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        //3.分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);
        for (ByteBuffer buf : bufs) {
            buf.flip();
        }
        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("-----------------------");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        //4.聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
        FileChannel channl2 = raf2.getChannel();

        channl2.write(bufs);


    }

    //字符集
    public void test5() {
        Map<String, Charset> map = Charset.availableCharsets();
        //支持多少种字符集
        for (Map.Entry<String, Charset> charsetEntry : map.entrySet()) {
            System.out.println(charsetEntry.getKey() + " " + charsetEntry.getValue());
        }
    }


    public void test6() throws CharacterCodingException {
        //按照GBK编码，按照GBK解码。所以不会乱码
        Charset cs1 = Charset.forName("GBK");
        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();
        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cbuf = CharBuffer.allocate(1024);
        cbuf.put("你好啊");
        cbuf.flip();

        //编码
        ByteBuffer bBuf = ce.encode(cbuf);
        //解码
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2.toString());

    }
}
