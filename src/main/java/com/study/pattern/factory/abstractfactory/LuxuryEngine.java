package com.study.pattern.factory.abstractfactory;

public class LuxuryEngine implements Engine {
    public void run() {
        System.out.println("高端引擎启动");
    }

    public void start() {
        System.out.println("高端引擎点火");
    }
}
