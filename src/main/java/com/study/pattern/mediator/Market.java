package com.study.pattern.mediator;

public class Market implements Department {
    private Mediator m;//持有中介者(总经理)的引用


    public Market(Mediator m) {
        super();
        this.m = m;
        m.register("Market", this);
    }

    public void selfAction() {
        System.out.println("市场部：接项目");
    }

    public void outAction() {
        System.out.println("汇报工作！项目承接进度，需要资金支持");
        m.command("finacial");
    }
}
