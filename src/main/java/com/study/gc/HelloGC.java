package com.study.gc;

public class HelloGC {
    public static void main(String[] args) throws Exception {
        System.out.println("********HelloGC");
        //Thread.sleep(Integer.MAX_VALUE);
        //如何查看某一个正在运行中的java程序，它的某个jvm参数是否开启？具体值是多少？
        //1.jps -l       2.jinfo -flag 属性 pid
        //E:\IdeaProjects\gof-23>jinfo -flag PrintGCDetails 6048
        //-XX:+PrintGCDetails

        //Java虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();
        //返回Java虚拟机试图使用的最大内存量
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("total_memory(-Xms) = " + totalMemory + " 字节 " + (totalMemory / (double) 1024 / 1024) + "MB");

        System.out.println("max_memory(-Xmx) = " + maxMemory + " 字节" + (maxMemory / (double) 1024 / 1024) + "MB");

        //byte[] bytes = new byte[20 * 1024 * 1024];
    }
}
