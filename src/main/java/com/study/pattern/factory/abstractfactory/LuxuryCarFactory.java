package com.study.pattern.factory.abstractfactory;

public class LuxuryCarFactory implements CarFactory {
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    public Seat createSeat() {
        return new LuxurySeat();
    }
}
