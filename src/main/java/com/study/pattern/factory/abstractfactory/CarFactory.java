package com.study.pattern.factory.abstractfactory;

public interface CarFactory {
    public Engine createEngine();

    public Seat createSeat();
}
