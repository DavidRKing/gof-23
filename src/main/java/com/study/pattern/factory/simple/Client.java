package com.study.pattern.factory.simple;

/**
 * 调用类
 */
public class Client {
    public static void main(String[] args) {
        //没有工厂模式的调用方式
        Car audi = new Audi();
        Car byd = new Byd();
        audi.run();
        byd.run();

        //简单工厂下调用方式,仅依赖于工厂
        Car bydCar = CarFactory.createCar("byd");
        bydCar.run();
    }
}
