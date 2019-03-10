package com.study.pattern.builder;

/**
 * 具体宇宙飞船的 装配器
 */
public class DavidAirShipDirector implements AirShipDirector {

    private AirShipBuilder builder;

    public DavidAirShipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    /**
     * 根据不同的builder 构建出不同的AirShip
     *
     * @return
     */
    public AirShip directAirShip() {
        Engine e = builder.buildEngine();
        EscapeTower tower = builder.buildEscapeTower();
        OrbitalModule ob = builder.buildOrbitalModule();
        return new AirShip(ob, e, tower);
    }
}
