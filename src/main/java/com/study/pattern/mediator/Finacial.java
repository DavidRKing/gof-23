package com.study.pattern.mediator;

public class Finacial implements Department {

    private Mediator m;//持有中介者(总经理)的引用


    public Finacial(Mediator m) {
        super();
        this.m = m;
        m.register("finacial", this);
    }

    public void selfAction() {
        System.out.println("财务部:我在数钱!!!");
    }

    public void outAction() {
        System.out.println("汇报工作！钱多，花不完");
    }
}
