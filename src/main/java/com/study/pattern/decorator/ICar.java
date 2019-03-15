package com.study.pattern.decorator;

/**
 * 抽象组件
 */
public interface ICar {
    void move();
}

//ConcreteComponent 具体角色（真实对象）
class Car implements ICar {
    public void move() {
        System.out.println("陆地上跑");
    }
}

//Decorator装饰角色
class SuperCar implements ICar {
    private ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    public void move() {
        car.move();
    }
}

//具体装饰对象
class FlyCar extends SuperCar {

    public FlyCar(ICar car) {
        super(car);
    }

    public void fly() {
        System.out.println("天上飞");

    }

    public void move() {
        super.move();
        fly();
    }
}

class WaterCar extends SuperCar {

    public WaterCar(ICar car) {
        super(car);
    }

    public void swim() {
        System.out.println("水上游");

    }

    public void move() {
        super.move();
        swim();
    }
}


