package com.study.gc.oom;

import sun.misc.VM;

import java.nio.ByteBuffer;

public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory:" + VM.maxDirectMemory() / (double) 1024 / 1024 + "MB");

        ByteBuffer bb = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
