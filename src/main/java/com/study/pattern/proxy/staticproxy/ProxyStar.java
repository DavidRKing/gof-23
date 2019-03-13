package com.study.pattern.proxy.staticproxy;

public class ProxyStar implements Star {

    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    public void confer() {
        System.out.println("proxyStar confer");
    }

    public void signContract() {
        System.out.println("proxyStar signContract");
    }

    public void bookTicket() {
        System.out.println("proxyStar confer bookTicket");
    }

    /**
     * 真实的明星来唱歌
     */
    public void sing() {
        star.sing();
    }

    public void collectMoney() {
        System.out.println("proxyStar confer collectMoney");
    }
}
