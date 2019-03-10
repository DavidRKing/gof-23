package com.study.pattern.factory.abstractfactory;

public class LowEngine implements Engine {
    public void run() {
        System.out.println("低端引擎启动");
    }

    public void start() {
        System.out.println("低端引擎点火");
    }
}
