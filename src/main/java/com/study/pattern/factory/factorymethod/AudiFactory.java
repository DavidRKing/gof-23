package com.study.pattern.factory.factorymethod;

public class AudiFactory implements CarFactory {

    public Car createCar() {
        return new Audi();
    }
}
