package com.study.pattern.factory.factorymethod;

/**
 * 工厂方法
 * 添加新类，只需要新增类和工厂，不需要修改代码。
 * 但是会导致新建的类特别多
 * <p>
 * 根据设计理论：推荐工厂方法模式，实际项目中一般用简单工厂
 */
public class Client {
    public static void main(String[] args) {
        Car audi = new AudiFactory().createCar();
        Car byd = new BydFactory().createCar();
    }
}
