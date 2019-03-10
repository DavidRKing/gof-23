package com.study.pattern.builder;

/**
 * 具体飞船的构建者
 */
public class DavidAirShipBuilder implements AirShipBuilder {
    public Engine buildEngine() {
        System.out.println("david引擎");
        return new Engine("david引擎");
    }

    public OrbitalModule buildOrbitalModule() {
        return new OrbitalModule("david  orbital module");
    }

    public EscapeTower buildEscapeTower() {
        return new EscapeTower("david escape tower");
    }
}
