package com.study.pattern.factory.abstractfactory;

public class LowCarFactory implements CarFactory {
    public Engine createEngine() {
        return new LowEngine();
    }

    public Seat createSeat() {
        return new LowSeat();
    }
}
