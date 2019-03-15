package com.study.pattern.decorator;

/**
 * 装饰器模式  (包装器模式)
 * 可以动态的增加或删除对象的职责，并使得需要装饰的具体构建类和具体装饰类可以独立变化
 * <p>
 * 可能会产生许多小对象。
 * 装饰模式和桥接模式的区别
 * 两个模式都是为了解决过多子类的问题，单他们的诱因不一样。桥接模式是对象自身现有
 * 机制沿着多个维度变化，是既有部分不稳定，装饰模式是为了增加新的功能。
 * IO流
 * Servlet API   HttpServletRequestWrapper 等
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();

        System.out.println("增加新的功能，飞行------------");
        FlyCar flyCar = new FlyCar(car);
        flyCar.move();

        System.out.println("增加新的功能,水里游------------");
        WaterCar waterCar = new WaterCar(car);
        waterCar.move();

        System.out.println("增加新的功能，水里游，天上飞");
        WaterCar waterCar1 = new WaterCar(flyCar);
        waterCar1.move();
    }
}
