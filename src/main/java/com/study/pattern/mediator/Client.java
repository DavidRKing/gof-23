package com.study.pattern.mediator;

/**
 * 同事对象之间的解耦
 * 市场部和财务部交互。他们没有直接交互，而是通过总经理来进行交互
 *
 * MVC模式 中的C 就是一个中介者对象。 M和V都和他打交道
 * 窗口游戏程序
 */
public class Client {
    public static void main(String[] args) {
        Mediator m = new President();
        Market market = new Market(m);
        Development devp = new Development(m);
        Finacial f = new Finacial(m);

        market.selfAction();
        market.outAction();
    }
}
