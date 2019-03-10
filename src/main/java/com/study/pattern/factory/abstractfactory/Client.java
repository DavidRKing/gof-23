package com.study.pattern.factory.abstractfactory;

/**
 * 抽象工厂
 * 不可以增加产品，可以增加产品族
 */
public class Client {
    public static void main(String[] args) {
        CarFactory factory = new LowCarFactory();
        factory.createEngine();
        factory.createSeat();
    }
}
