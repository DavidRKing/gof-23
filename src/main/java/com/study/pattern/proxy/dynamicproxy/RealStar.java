package com.study.pattern.proxy.dynamicproxy;

/**
 * 真实明星  面谈，签约 订票，唱歌.........
 */
public class RealStar implements Star {
    public void confer() {
        System.out.println("real start confer");
    }

    public void signContract() {
        System.out.println("real start signContract");
    }

    public void bookTicket() {
        System.out.println("real start bookTicket");
    }

    public void sing() {
        System.out.println("real start sing");

    }

    public void collectMoney() {
        System.out.println("real start collectMoney");
    }
}
