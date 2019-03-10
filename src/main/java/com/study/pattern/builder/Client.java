package com.study.pattern.builder;

/**
 * 建造者模式
 * <p>
 * 工厂模式一般都是创建一个产品，注重的是把这个产品创建出来就行，不关心这个产品的组成部分。
 * 建造者模式也是创建一个产品，但是不仅要把这个产品创建出来，还要关心这个产品的组成细节，
 * 组成过程，从代码上看，建造者模式在创建产品时，这个产品有很多方法，建造者模式会根据这些相同方法但是不同
 * 执行顺序建造出不同组成细节的产品
 * <p>
 * 整体 与  细节的 差异
 */
public class Client {
    public static void main(String[] args) {
        AirShipDirector director = new DavidAirShipDirector(new DavidAirShipBuilder());
        director.directAirShip();
    }
}
